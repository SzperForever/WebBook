package book.model;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String name;
    private double price;
    private int stock;//库存
    private String imgPath;
    private int discount; //折扣， 1为1折

}
