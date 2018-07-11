package book.service.Impl;

import book.dao.OrderDao;
import book.model.Order;
import book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public boolean addOrder(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public List<Order> getAllOrder(int userId) {
        return orderDao.getAllOrderByUserId(userId);
    }
}
