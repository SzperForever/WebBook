import book.dao.OrderDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderDaoTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/bean.xml","spring/spring-mvc.xml"});
    }

    @Test
    public void findById() throws Exception {
        OrderDao orderDao = ((OrderDao) applicationContext.getBean("orderDao"));
        System.out.println(orderDao.getElementById(1));
    }
}
