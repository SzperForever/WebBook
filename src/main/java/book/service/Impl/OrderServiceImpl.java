package book.service.Impl;

import book.dao.OrderDao;
import book.model.Order;
import book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public Order addOrder(Order order) {
        if(order == null){
            throw new RuntimeException("订单为空");
        }
        if(orderDao.insertOrder(order) == false){
            throw new RuntimeException("创建订单失败");
        }
        if(orderDao.insertOrder(order) == true){
            order.setStatus(-1);
        }
        return order;
    }

    @Override
    public List<Order> getAllOrder(int userId) {
        return orderDao.getAllOrderByUserId(userId);
    }

    @Override
    public boolean changeOrderStatus(int OrderId) {
        Order order = orderDao.getOrderById(OrderId);
        if(order == null){
            throw new RuntimeException("订单不存在");
        }
        return true;
    }

    @Override
    public Order getOrderById(int id) {

        return orderDao.getOrderById(id);
    }
}
