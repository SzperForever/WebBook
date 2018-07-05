package book.mapper;

import book.model.BookInOrder;
import book.model.Item;

import java.util.List;


public interface ItemMapper {
    boolean insertItem(Item item);

    /**
     * 仅提供更新num功能
     * @param item 仅包含num更新的item
     * @return
     */
    boolean updateItem(Item item);
    boolean deleteItem(int id);
    Item getItemById(int id);

    List<BookInOrder> getBooksByOrderId(int orderId);
    List<Item> getAllItem();
}
