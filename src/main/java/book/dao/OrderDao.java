package book.dao;

import book.model.Order;

import java.util.HashMap;
import java.util.List;

public interface OrderDao {
    boolean insertOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(int id);

    Order getOrderById(int id);

    List<Order> getAllOrder();

    List<Order> getAllOrderByUserId(int userId);

    boolean updateStatus(HashMap hashMap);



    int getStatus(int id);
}
