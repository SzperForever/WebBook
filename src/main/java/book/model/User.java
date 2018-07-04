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
}
