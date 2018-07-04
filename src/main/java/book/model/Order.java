package book.model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private int totalPrice;
    private int userId;
    private int addressId;
    private String username;
    private String address;
    private List<Book> books;
}
