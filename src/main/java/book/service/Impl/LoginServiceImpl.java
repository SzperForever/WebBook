package book.service.Impl;

import book.dao.UserDao;
import book.model.User;
import book.service.LoginService;
import book.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;
    @Override
    public void Login(String username, String password) {
        if(StringUtil.isNullOrEmpty(username)){
            throw new RuntimeException("用户名为空");
        }
        if(StringUtil.isNullOrEmpty(password)){
            throw new RuntimeException("密码为空");
        }
        User user = userDao.findUserByName(username);
        if(user == null){
            throw new RuntimeException("用户不存在");
        }
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("密码不正确");
        }

    }

    @Override
    public void Register(User user) {

    }
}
