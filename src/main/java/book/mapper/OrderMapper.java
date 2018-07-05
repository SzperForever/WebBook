package book.mapper;

import book.model.Order;

import java.util.List;

public interface OrderMapper {
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(int id);
    Order getOrderById(int id);
    List<Order> getAllOrder();
}
