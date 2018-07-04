package book.mapper;

import book.model.Book;

public interface BookMapper {
    Book getBookById(int id);
    boolean insertBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
}
