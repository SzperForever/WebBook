package book.mapper;

import book.model.Order;

public interface OrderMapper {
    Order getOrderById(int id);
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(int id);
}
