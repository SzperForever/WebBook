package book.dao;

import book.model.Book;
import book.vo.BookInfo;
import book.vo.PageJson;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookDao {
    Book getBookById(int id);

    boolean insertBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(int id);

    ArrayList<Book> getAllBooks();
    int getStockById(int id);
    ArrayList<Book> getPageBooks(HashMap hashMap);
    boolean updateBookInfo(BookInfo bookInfo);

}
