package book.mapper;

import book.model.Book;
import book.model.Item;

import java.util.List;


public interface ItemMapper {
    Item getItemById(int id);
    boolean insertItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(int id);

    List<Book> getBooksByOrderId(int orderId);
}
