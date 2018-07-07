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
    BookDao bookMapper;
    @Override
    public boolean Add(Book book) {
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Book> getAllElements() {
        return bookMapper.getAllBooks();
    }

    @Override
    public Book getElementById(int id) {
        return null;
    }
}
