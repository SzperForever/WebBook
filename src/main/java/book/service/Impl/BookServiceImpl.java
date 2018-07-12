package book.service.Impl;

import book.dao.BookDao;
import book.model.Book;
import book.service.BookService;
import book.vo.PageJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
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

    @Override
    public int getStockById(int id) {
        return bookDao.getStockById(id);
    }

    @Override
    public ArrayList<Book> getPageBooks(PageJson pageJson) {
        return bookDao.getPageBooks(PageJson.pageInfo(pageJson));
    }
}
