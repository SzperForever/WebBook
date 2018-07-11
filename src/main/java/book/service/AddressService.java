

package book.service;

import book.model.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddressByUserId(int userId);
}
