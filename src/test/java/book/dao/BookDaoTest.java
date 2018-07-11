package book.dao;

import book.model.Book;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/bean.xml", "classpath:spring/spring-mvc.xml"})
public class BookDaoTest {
    @Autowired
    BookDao bookDao;
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
        for (Book book : bookDao.getAllBooks()) {
            System.out.println(book);
        }
    }
    public boolean Test(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("start", 1);
        hashMap.put("end", 5);
        List<Book> lists = bookDao.getPageBooks(hashMap);
        for(Book book : lists){
            System.out.println(book.getName());
        }
        return true;
    }
    @Test
    public void getAllTest(){
        Assert.assertTrue(this.Test());
    }
}
