package book.service;

import book.model.User;

public interface UserService {
    User loginAuth(String username, String password);
}
