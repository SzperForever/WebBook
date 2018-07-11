package book.dao;

import book.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(int id);

    String getUserNameById(int id);
    User findUserByName(String name);

    List<User> getAllUser();
}
