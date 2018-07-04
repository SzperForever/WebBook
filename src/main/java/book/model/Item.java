package book.model;

import lombok.Data;

@Data
public class Item {
    private int id;
    private int orderId;
    private int bookId;
}
