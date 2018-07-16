package book.dao;

import book.model.User;
import book.vo.BookInfo;

import java.util.List;

public interface UserDao {
    User getUserById(int id);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(int id);

    String getUserNameById(int id);

    User getUserByName(String name);

    List<User> getAllUser();
    boolean unLockUser(int id);

}
