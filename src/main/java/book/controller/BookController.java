package book.controller;

import book.model.Book;
import book.model.BookInOrder;
import book.service.BookService;
import book.vo.MsgInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        System.out.println("session:"+ bookInOrders);
        Book book = bookService.getBookByID(bookId);
        //System.out.println(book);
        for (BookInOrder bookInOrder : bookInOrders){
            if(book.getId() == bookInOrder.getId()){
                bookInOrder.setNum(bookInOrder.getNum() + 1);
                httpSession.setAttribute("cart", bookInOrders);
                msgInfo.setCode(1);
                msgInfo.setMsg("Success");
                return msgInfo;
            }
        }
        BookInOrder book1 = BookInOrder.getNewInstance(book, 1);
        //bookInOrders.add(BookInOrder.getNewInstance(book, 1));
        bookInOrders.add(book1);
        httpSession.setAttribute("cart", bookInOrders);
        System.out.println("BookInOrders: " + bookInOrders.get(0).getName());
        msgInfo.setCode(1);
        msgInfo.setMsg("Success");
        return msgInfo;
    }

    @RequestMapping(value = "getCartBooks")
    @ResponseBody
    public List<BookInOrder>  getCartBooks(HttpSession httpSession){
        System.out.println("Session: "  + httpSession.getAttribute("cart"));
        return (List<BookInOrder>)httpSession.getAttribute("cart");
    }

}
