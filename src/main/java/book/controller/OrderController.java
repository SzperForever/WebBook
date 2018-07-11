package book.controller;

import book.model.BookInOrder;
import book.model.Order;
import book.model.User;
import book.service.ItemService;
import book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/submitOrder/{addressID}", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> submitOrder(HttpSession httpSession, @PathVariable("addressID")Integer addressId){
        HashMap<String,String> result = new HashMap<>();

        List<BookInOrder> books = ((List<BookInOrder>) httpSession.getAttribute("chart"));
        User user = (User)httpSession.getAttribute("user");

        double totalPrice = 0;
        for (BookInOrder book : books) {
            totalPrice += book.getPrice() * book.getNum();
        }

        try{
            Order order = Order.newInstance(totalPrice,addressId,user.getId());
            orderService.addOrder(order);
            for (BookInOrder book : books) {
                itemService.addItem(order.getId(),book.getId(),book.getNum());
            }
            result.put("state","success");
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            result.put("state","fail");
            result.put("reason",e.getMessage());
            return result;
        }

    }

    @RequestMapping(value = "/getAllOrder",method = RequestMethod.POST)
    @ResponseBody
    public List<Order> getAllOrder(HttpSession httpSession){
        User user = ((User) httpSession.getAttribute("user"));
        List<Order> orders = orderService.getAllOrder(user.getId());
        return orders;
    }

}
