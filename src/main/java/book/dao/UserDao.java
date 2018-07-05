package book.dao;

import book.mapper.UserMapper;
import book.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDao implements BaseDao<User>{
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public User getElementById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean delete(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public List<User> getAllElements() {
        return userMapper.getAllUser();
    }
}
