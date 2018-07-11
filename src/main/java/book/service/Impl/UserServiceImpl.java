package book.service.Impl;

import book.dao.UserDao;
import book.model.User;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User loginAuth(String username, String password) throws RuntimeException {
        User user = userDao.getUserByName(username);
        if(user == null){
            throw  new RuntimeException("User doesn't exist");
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            throw new RuntimeException("Password doesn't match");
        }
    }
}

