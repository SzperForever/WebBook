package book.service;

import book.model.User;

public interface UserService {
    User loginAuth(String username, String password);
    User getUserByName(String username);
    boolean registerAuth(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
}
