package book.service;

import book.model.User;
import book.vo.BookInfo;

import java.util.List;

public interface UserService {
    User loginAuth(String username, String password);
    User getUserByName(String username);
    boolean registerAuth(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
    List<User> getAllUsers();
    boolean unlockUser(int id);
}
