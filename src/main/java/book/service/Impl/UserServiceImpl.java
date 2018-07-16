package book.service.Impl;

import book.dao.UserDao;
import book.model.User;
import book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User loginAuth(String username, String password) throws RuntimeException {
        User user = userDao.getUserByName(username);
        if(user == null){
            throw  new RuntimeException("User doesn't exist");
        }

        if(user.getFails() >= 3){
            throw new RuntimeException("账户已被锁定");
        }

        if(user.getPassword().equals(password)){
            return user;
        }
        else{
            throw new RuntimeException("Password doesn't match");
        }
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public boolean registerAuth(User user) {
        if(user == null){
            throw new RuntimeException("用户为空");
        }
        else if(userDao.getUserByName(user.getUsername()) != null){
            throw new RuntimeException("用户已经存在");
        }
        else{
            userDao.insertUser(user);
            return true;
        }
    }

    @Override
    public boolean deleteUser(int id) {

        boolean result = userDao.deleteUserById(id);
        if(result == false){
            throw new RuntimeException("删除用户失败");
        }
        else
            return true;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUser();
    }

    @Override
    public boolean unlockUser(int id) {
        boolean result = userDao.unLockUser(id);
        if(result == false) {
            throw new RuntimeException("解锁失败");
        }
        else
            return true;
    }


}

