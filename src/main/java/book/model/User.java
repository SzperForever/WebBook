package book.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private int role;
    private int fails;
    private String email;

    public User() {

    }

    private User(String username, String password, int role, String email) throws Exception {
        this.username = username;
        this.password = password;
        if (role != 0 && role != 1) {
            throw new Exception("role must be 0 or 1");
        }
        this.role = role;
        this.fails = 0;
        this.email = email;
    }

    public static User newUpdateInstance(int id, String username, String password, int role, String email) throws Exception {
        User user = new User(username, password, role, email);
        user.setId(id);
        return user;
    }

    public static User newInsertInstance(String username, String password, String email) throws Exception {
        if (username == null || password == null || email == null) {
            throw new NullPointerException("参数不允许存在null");
        }
        return new User(username, password, 0, email);
    }
}
