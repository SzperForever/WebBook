package book.dao;

import book.model.Address;

import java.util.List;

public interface AddressDao {
    Address getAddressById(int id);

    boolean insertAddress(Address address);

    /**
     * 只允许修改Content
     *
     * @param address 含有userId和新content
     * @return
     */
    boolean updateAddress(Address address);

    boolean deleteAddress(int id);

    String getAddressNameById(int addressId);



    List<Address> getAllAddress();

    List<Address> getAllAddressByUserId(int userID);
}
