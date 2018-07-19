package book.service.Impl;

import book.dao.OrderDao;
import book.model.Order;
import book.service.OrderService;
import book.vo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
        boolean result = orderDao.insertOrder(order);

        if(result == false){
            throw new RuntimeException("创建订单失败");
        }
        if(result == true){
            order.setStatus(0);
        }
        return order;
    }

    @Override
    public List<Order> getAllOrder(int userId) {
        return orderDao.getAllOrderByUserId(userId);
    }

    @Override
    public boolean changeOrderStatus(OrderInfo orderInfo) {
        Order order = orderDao.getOrderById(orderInfo.getOrderId());
        int orderId = orderInfo.getOrderId();
        int status = orderInfo.getStatus();
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("orderId", orderId);
        if(order == null){
            throw new RuntimeException("订单不存在");
        }
        if(status == 0){
            status = 1;
            hashMap.put("status", status);
            return orderDao.updateStatus(hashMap);
            //throw new RuntimeException("已发货");
        }
        if(status == 1){
            status = 2;
            hashMap.put("status", status);
            return orderDao.updateStatus(hashMap);
            //throw new RuntimeException("已签收");
        }
        if(status == -1){
            status = -2;
            hashMap.put("status",status);
            return orderDao.updateStatus(hashMap);
            //throw new RuntimeException("退货");
        }
        if(status == -2){
            hashMap.put("status", null);
            return orderDao.updateStatus(hashMap);
        }
        //hashMap.put("status", status);
        return true;
    }
    @Override
    public Order getOrderById(int id) {

        return orderDao.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrder();
    }

    @Override
    public boolean updateStatus(HashMap hashMap) {
        if(hashMap == null){
            throw new RuntimeException("提交订单失败");
        }
        else{
            orderDao.updateStatus(hashMap);
        }
        return true;
    }
}
