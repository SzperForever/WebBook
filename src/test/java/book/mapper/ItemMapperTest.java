package book.mapper;

import book.dao.ItemDao;
import book.model.BookInOrder;
import book.model.Item;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/bean.xml", "classpath:spring/spring-mvc.xml"})
public class ItemMapperTest {
    @Autowired
    ItemDao itemMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        for (Item item : itemMapper.getAllItem()) {
            System.out.println(item);
        }
    }

    @Test
    public void insertItem() {
        Item item = Item.getNewInstance(1, 1, 10);
        Assert.assertTrue(itemMapper.insertItem(item));
    }

    @Test
    public void updateItem() {
        Item item = Item.updateNum(1,1,5);
        Assert.assertTrue(itemMapper.updateItem(item));
    }

    @Test
    public void deleteItem() {
        Assert.assertTrue(itemMapper.deleteItem(2));
    }

    @Test
    public void getItemById() {
        System.out.println(itemMapper.getItemById(1));
    }

    @Test
    public void getBooksByOrderId() {
        for (BookInOrder bookInOrder : itemMapper.getBooksByOrderId(1)) {
            System.out.println(bookInOrder);
        }
    }
}