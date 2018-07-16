package book.controller;

import book.model.Order;
import book.service.ItemService;
import book.service.OrderService;
import book.vo.BookJson;
import book.vo.MsgInfo;
import book.vo.OrderJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String,String> submitOrder(@RequestBody OrderJson orderJson){
        System.err.println("userID : " + orderJson.getUserId());
        System.err.println("addresID : " + orderJson.getAddressId());
        System.err.println("price : " + orderJson.getPrice());

        for (BookJson bookJson : orderJson.getBooks()) {
            System.err.println(bookJson.getId());
        }

        HashMap<String,String> result = new HashMap<>();


        double totalPrice = orderJson.getPrice();

        try{
            Order order = Order.newInstance(totalPrice,orderJson.getAddressId(),orderJson.getUserId());
            orderService.addOrder(order);
            for (BookJson book : orderJson.getBooks()) {
                boolean insertResult = itemService.addItem(order.getId(),book.getId(),book.getNum());
                if(insertResult == false){
                    throw new Exception("插入Item失败");
                }
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
    public List<Order> getAllOrder(Integer userId){
        List<Order> orders = orderService.getAllOrder(userId);
        return orders;
    }
    @RequestMapping(value = "/changeOrderStatus", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo changeStatus(int OrderId, int virginState, int status){
        MsgInfo msgInfo = new MsgInfo();
        Order order = orderService.getOrderById(OrderId);
        order.setStatus(virginState);
        if(status != virginState){
            order.setStatus(status);
            if(virginState == -1 && status == 0){
                msgInfo.setCode(1);
                msgInfo.setMsg("发货成功");
            }
            if(virginState == 0 && status == 1){
                msgInfo.setCode(1);
                msgInfo.setMsg("收货成功");
            }
        }
        else{
            msgInfo.setCode(0);
            msgInfo.setMsg("订单状态已是最新");
        }
        return msgInfo;
    }

}
