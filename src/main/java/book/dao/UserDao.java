package book.dao;

import book.mapper.UserMapper;
import book.model.User;
import org.springframework.beans.factory.annotation.Autowired;

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
}
