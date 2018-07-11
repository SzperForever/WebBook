package book.service;

import book.model.Order;

import java.util.List;

public interface OrderService {
    boolean addOrder(Order order);

    List<Order> getAllOrder(int userId);

}
