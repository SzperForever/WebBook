package book.model;

import lombok.Data;

@Data
public class Address {
    private int id;
    private int userId;
    private String content;

    public static Address updateContent(int id, String content) throws NullPointerException {
        if (content == null) {
            throw new NullPointerException("content 不允许为null");
        }
        Address address = new Address();
        address.setId(id);
        address.setContent(content);
        return address;
    }

    public static Address newInstance(int userId, String content) throws NullPointerException {
        if (content == null) {
            throw new NullPointerException("content 不允许为null");
        }
        Address address = new Address();
        address.setUserId(userId);
        address.setContent(content);
        return address;
    }

}
