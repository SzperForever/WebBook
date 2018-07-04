package book.dao;

import book.mapper.OrderMapper;
import book.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao implements BaseDao<Order>{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public boolean add(Order o) {
        return false;
    }

    @Override
    public Order getElementById(int id) {
        return orderMapper.getOrderById(id);
    }
}
