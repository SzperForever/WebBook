package book.model;


import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private int totalPrice;
    private int userId;
    private int addressId;
    private String username;
    private String address;
    private List<BookInOrder> books;


    /**
     * 不提共修改UserId
     */

    /**
     * @param totalPrice 修改的价格
     * @return 仅用于修改价格的Order实例
     */
    public static Order updateTotalPrice(int id, int totalPrice) throws Exception {
        if (-1 == totalPrice) {
            throw new Exception("totalPrice 不允许为负值");
        }
        Order order = new Order();
        order.setId(id);
        order.setAddressId(-1);
        order.setUserId(-1);
        order.setTotalPrice(totalPrice);
        return order;
    }

    /**
     * @param addressId 修改的地址
     * @return 仅用于修改地址的Order实例
     */
    public static Order updateAddressId(int id, int addressId) throws Exception {
        if (-1 == addressId) {
            throw new Exception("addressId 不允许为负值");
        }
        Order order = new Order();
        order.setId(id);
        order.setAddressId(addressId);
        order.setUserId(-1);
        order.setTotalPrice(-1);
        return order;
    }

    public static Order newInstance(int totalPrice, int addressId, int userId) throws Exception {
        if (-1 == totalPrice || -1 == addressId || -1 == userId) {
            throw new Exception("参数不允许为负值");
        }
        Order order = new Order();
        order.setTotalPrice(totalPrice);
        order.setUserId(userId);
        order.setAddressId(addressId);
        return order;
    }


}
