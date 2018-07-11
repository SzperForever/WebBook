package book.service;

import book.dao.UserDao;
import book.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface LoginService {
    public void Login(String username, String password);
    public void Register(User user);
}
