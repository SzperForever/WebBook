package book.mapper;

import book.dao.BookDao;
import book.model.Address;
import book.model.Book;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/bean.xml", "classpath:spring/spring-mvc.xml"})
public class BookDaoTest {
    @Autowired
    BookDao bookMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        for (Book book : bookMapper.getAllBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void updateBook() {
        Book book = Book.updateName(3, "4Book");
        Assert.assertTrue(bookMapper.updateBook(book));
    }

    @Test
    public void InsertBook() {
        Book book = new Book();
        book = Book.createBook("3Book", 34.6, 40, "d", 9);
        Assert.assertTrue(bookMapper.insertBook(book));

    }

    @Test
    public void deleteBook() {
        Assert.assertTrue(bookMapper.deleteBook(2));

    }
    public boolean Test(){
        System.out.println("stock: " + bookMapper.getStockById(3));
        return true;
    }
    @Test
    public void getStock(){
        Assert.assertTrue(Test());
    }

}
