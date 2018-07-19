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

    public static Book updateName(int id, String Name) {
        Book book = new Book();
        book.setId(id);
        book.setName(Name);
        book.setDiscount(-1);
        book.setImgPath(null);
        book.setStock(-1);
        book.setPrice(-1);
        return book;
    }

    public static Book newDeleteBook(int id){
        Book book = new Book();
        book.setId(id);
        book.setName(null);
        book.setDiscount(-1);
        book.setImgPath(null);
        book.setStock(-2);
        book.setPrice(-1);
        return book;
    }

    public static Book createBook(String name, double price, int stock, String imgPath, int discount) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStock(stock);
        book.setImgPath(imgPath);
        book.setDiscount(discount);
        return book;
    }

}
