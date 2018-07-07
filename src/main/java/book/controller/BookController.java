package book.controller;

import book.model.Book;
import book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "getBooks")
    @ResponseBody
    public List<Book> getBooks() {
        System.out.println("=========");
        return bookService.getAllElements();
    }
}
