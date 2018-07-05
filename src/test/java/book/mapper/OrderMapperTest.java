package book.mapper;

import book.model.Order;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mvc.xml", "classpath:spring/bean.xml"})
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        List<Order> orders = orderMapper.getAllOrder();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void insertOrder() {
        try {
            Order order = Order.newInstance(10, 1, 1);
            Assert.assertTrue(orderMapper.insertOrder(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateOrder() {
        // Order order = Order.updateAddressId(4,2);
        Order order = Order.updateTotalPrice(4,1000);
        Assert.assertTrue(orderMapper.updateOrder(order));
    }

    @Test
    public void deleteOrder() {
        Assert.assertTrue(orderMapper.deleteOrder(5));
    }

    @Test
    public void getOrderById() {
        Order order = orderMapper.getOrderById(6);
        Assert.assertEquals("leehaoze",order.getUsername());
    }
}