package book.model;

import lombok.Data;

@Data
public class BookInOrder extends Book {
    private int num;
    public static BookInOrder getNewInstance(Book book, int num){
        BookInOrder bookInOrder = new BookInOrder();
        bookInOrder.setNum(num);
        bookInOrder.setImgPath(book.getImgPath());
        bookInOrder.setName(book.getName());
        bookInOrder.setPrice(book.getPrice());
        bookInOrder.setStock(book.getStock());
        bookInOrder.setDiscount(book.getDiscount());
        bookInOrder.setId(book.getId());
        return bookInOrder;
    }
}
