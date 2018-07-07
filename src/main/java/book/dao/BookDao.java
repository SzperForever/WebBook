package book.dao;

import book.model.Book;

import java.util.ArrayList;

public interface BookDao {
    Book getBookById(int id);
    boolean insertBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
    ArrayList<Book> getAllBooks();
}
