package book.mapper;

import book.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//配置spring和junit整合，这样junit在启动时就会加载spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/bean.xml","classpath:spring/spring-mvc.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUserById() {
        System.out.println(userMapper.getUserById(1));
    }

    @Test
    public void insertUser() {
        try {
            User user = User.newInsertInstance("ShaoZhuPeng", "199804", 1, "123456789@qq.com");
            boolean result =  userMapper.insertUser(user);
            Assert.assertTrue(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        try {
            User user = User.newUpdateInstance(3,null,null,1,null);
            boolean result = userMapper.updateUser(user);
            Assert.assertTrue(result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUserById() {
        Assert.assertTrue(userMapper.deleteUserById(2));
    }

    @Test
    public void getUserNameById() {
        Assert.assertEquals("leehaoze", userMapper.getUserNameById(1));
    }

    @After
    public void ShowResults(){
        List<User> users = userMapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}