package book.service.Impl;

import book.dao.BookDao;
import book.model.Book;
import book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getAllBook() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookByID(int id) {
        return bookDao.getBookById(id);
    }
}
