package book.service;

import book.model.Book;
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
@ContextConfiguration({"classpath:spring/bean.xml", "classpath:spring/spring-mvc.xml"})
public class BookServiceTest {
    @Autowired
    BookService bookService;
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
        for (Book book : bookService.getAllElements()) {
            System.out.println(book);
        }
    }
    public boolean Test(){
        List<Book> lists = bookService.getAllElements();
        for(Book book : lists){
            System.out.println(book.getName());
        }
        return true;
    }
    @Test
    public void getAllTest(){
        List<Book> Lists;
        Assert.assertTrue(this.Test());
    }
}
