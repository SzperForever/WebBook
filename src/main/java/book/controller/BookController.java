package book.controller;

import book.model.Book;
import book.model.BookInOrder;
import book.service.BookService;
import book.vo.MsgInfo;
import book.vo.PageJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "getBooks")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getAllBook();
    }
    @RequestMapping(value = "addToCart/{bookId}", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo addToCart(@PathVariable("bookId") Integer bookId, HttpSession httpSession){
        MsgInfo msgInfo = new MsgInfo();
        if(bookId == null){
            msgInfo.setCode(0);
            return msgInfo;
        }
        if(httpSession.getAttribute("cart") == null){
            List<BookInOrder> books = new LinkedList<>();
            httpSession.setAttribute("cart", books);
        }

        List<BookInOrder>  bookInOrders = (List<BookInOrder>)httpSession.getAttribute("cart");
        Book book = bookService.getBookByID(bookId);
        int stock = bookService.getStockById(bookId);
        for (BookInOrder bookInOrder : bookInOrders){
            if(book.getId() == bookInOrder.getId()){
                int sum = bookInOrder.getNum() + 1;
                if(stock < sum){
                    msgInfo.setCode(0);
                    msgInfo.setMsg("库存不足");
                    return msgInfo;
                }
                bookInOrder.setNum(sum);
                httpSession.setAttribute("cart", bookInOrders);
                msgInfo.setCode(1);
                msgInfo.setMsg("Success");
                return msgInfo;
            }
        }
        BookInOrder book1 = BookInOrder.getNewInstance(book, 1);
        bookInOrders.add(book1);
        httpSession.setAttribute("cart", bookInOrders);
        msgInfo.setCode(1);
        msgInfo.setMsg("Success");
        return msgInfo;
    }

    @RequestMapping(value = "getCartBooks")
    @ResponseBody
    public List<BookInOrder>  getCartBooks(HttpSession httpSession){
        return (List<BookInOrder>)httpSession.getAttribute("cart");
    }
    @RequestMapping(value = "pageInfo")
    @ResponseBody
    public ArrayList<Book> getPageInfo(PageJson pageJson){
        return bookService.getPageBooks(pageJson);
    }
    @RequestMapping(value = "pageInfos")
    @ResponseBody
    public ArrayList<Book> getPageInfos(){
        PageJson pageJson = new PageJson();
        pageJson.setPage(1);
        pageJson.setSize(5);
        return bookService.getPageBooks(pageJson);
    }


}
