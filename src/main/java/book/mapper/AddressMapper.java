package book.mapper;

import book.model.Address;

public interface AddressMapper {
    Address getAddressById(int id);
    boolean insertAddress(Address address);
    boolean updateAddress(Address address);
    boolean deleteAddress(int id);

    String  getAddressNameByUserId(int userId);


}
