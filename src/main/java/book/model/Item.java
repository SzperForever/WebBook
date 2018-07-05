package book.model;

import lombok.Data;

@Data
public class Item {
    private int id;
    private int orderId;
    private int bookId;
    private int num;

    public static Item updateNum(int orderId, int bookId, int num) {
        Item item = new Item();
        item.setNum(num);
        item.setBookId(bookId);
        item.setOrderId(orderId);
        return item;
    }

    public static Item getNewInstance(int orderId,int bookId,int num){
        Item item = new Item();
        item.setOrderId(orderId);
        item.setBookId(bookId);
        item.setNum(num);
        return item;
    }

}
