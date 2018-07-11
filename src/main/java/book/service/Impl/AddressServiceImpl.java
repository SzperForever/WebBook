package book.service.Impl;

import book.dao.AddressDao;
import book.model.Address;
import book.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public boolean addAddress(Address address) {
        return addressDao.insertAddress(address);
    }

    @Override
    public List<Address> getAllAddressByUserId(int userId) {
        return addressDao.getAllAddressByUserId(userId);
    }
}
