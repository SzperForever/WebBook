package book.service;

import book.model.Book;
import book.vo.PageJson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBook();

    Book getBookByID(int id);
    int getStockById(int id);
    ArrayList<Book> getPageBooks(PageJson pageJson);
    boolean updateBook(Book book);
}
