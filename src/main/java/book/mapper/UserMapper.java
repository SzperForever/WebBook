package book.mapper;

import book.model.User;

public interface UserMapper {
    User getUserById(int id);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUserById(int id);

    String getUserNameById(int id);
}
