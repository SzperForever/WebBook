package book.dao;

import book.mapper.OrderMapper;
import book.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao implements BaseDao<Order>{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean add(Order o) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public Order getElementById(int id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public boolean delete(int id) {
        return orderMapper.deleteOrder(id);
    }

    @Override
    public List<Order> getAllElements() {
        return orderMapper.getAllOrder();
    }
}
