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
        return bookService.getAllElements();
    }
    @RequestMapping(value = "addToCart/{bookId}", method = RequestMethod.POST)
    @ResponseBody
    public MsgInfo addToCart(@PathVariable("bookId") Integer bookId, HttpSession httpSession){
        MsgInfo msgInfo = new MsgInfo();
        //System.out.println(bookId);
        if(bookId == null){
            msgInfo.setCode(0);
            return msgInfo;
            //msgInfo.setMsg("fail");
        }
        if(httpSession.getAttribute("cart") == null){
            List<BookInOrder> books = new LinkedList<>();
            httpSession.setAttribute("cart", books);
        }

        List<BookInOrder>  bookInOrders = (List<BookInOrder>)httpSession.getAttribute("cart");
        System.out.println("session:"+ bookInOrders);
        Book book = bookService.getElementById(bookId);
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
    @RequestMapping(value = "/addToChart/{bookId}", method = RequestMethod.POST)
    @ResponseBody
    public String addToChart(@PathVariable("bookId") Integer bookId, HttpSession httpSession){
        if(bookId == null){
            return "fail";
        }

        if(httpSession.getAttribute("chart") == null){
            List<BookInOrder> books = new LinkedList<>();
            httpSession.setAttribute("chart",books);
        }

        List<BookInOrder> books = ((List<BookInOrder>) httpSession.getAttribute("chart"));

        Book targetBook = bookService.getElementById(bookId);

        for (BookInOrder book : books) {
            if(book.getId() == targetBook.getId()){
                book.setNum(book.getNum() + 1);
                httpSession.setAttribute("chart",books);
                return "Success";
            }
        }

        books.add(BookInOrder.getNewInstance(targetBook,1));

        httpSession.setAttribute("chart",books);

        return "Success";

    }
    @RequestMapping(value = "getChartBooks")
    @ResponseBody
    public List<BookInOrder>  getChartBooks(HttpSession httpSession){
        System.out.println("Session: "  + httpSession.getAttribute("chart"));
        return (List<BookInOrder>)httpSession.getAttribute("chart");
    }
    @RequestMapping(value = "getCartBooks")
    @ResponseBody
    public List<BookInOrder>  getCartBooks(HttpSession httpSession){
        System.out.println("Session: "  + httpSession.getAttribute("cart"));
        return (List<BookInOrder>)httpSession.getAttribute("cart");
    }
}
