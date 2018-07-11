package book.service;

import book.model.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order);

    List<Order> getAllOrder(int userId);
    boolean changeOrderStatus(int OrderId);
    Order getOrderById(int id);

}
