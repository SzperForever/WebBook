package book.service;

import book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBook();

    Book getBookByID(int id);

}
