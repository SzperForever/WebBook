package book.service;

import book.model.Book;


import java.util.List;

public interface BookService {

    public boolean Add(Book book);
    public boolean update(Book book);

    public boolean delete(int id);

    public List<Book> getAllElements();

    public Book getElementById(int id);
}
