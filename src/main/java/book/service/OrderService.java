package book.service;

import book.model.Order;
import book.vo.OrderInfo;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    Order addOrder(Order order);
    List<Order> getAllOrder(int userId);
    boolean changeOrderStatus(OrderInfo orderInfo);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    boolean updateStatus(HashMap hashMap);
}
