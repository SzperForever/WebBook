package book.vo;

import lombok.Data;

import java.util.List;

@Data
public class OrderJson {
    private int userId;
    private int addressId;
    private int price;
    private List<BookJson> books;
}
