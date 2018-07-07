package book.mapper;

import book.dao.AddressDao;
import book.model.Address;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/bean.xml", "classpath:spring/spring-mvc.xml"})
public class AddressMapperTest {
    @Autowired
    AddressDao addressDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        for (Address address : addressDao.getAllAddress()) {
            System.out.println(address);
        }
    }

    @Test
    public void getAddressById() {
        System.out.println(addressDao.getAddressById(1));
    }

    @Test
    public void insertAddress() {
        Address address = Address.newInstance(1, "shankeda");
        Assert.assertTrue(addressDao.insertAddress(address));
    }

    @Test
    public void updateAddress() {
        Address address = Address.updateContent(1, "SDUST");
        Assert.assertTrue(addressDao.updateAddress(address));
    }

    @Test
    public void deleteAddress() {
        Assert.assertTrue(addressDao.deleteAddress(2));
    }

    @Test
    public void getAddressNameByUserId() {
        Assert.assertEquals("SDUST", addressDao.getAddressNameByUserId(1));
    }
}