package book.dao;

import book.mapper.AddressMapper;
import book.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDao implements BaseDao<Address> {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public boolean add(Address address) {
        return addressMapper.insertAddress(address);
    }

    @Override
    public boolean update(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public boolean delete(int id) {
        return addressMapper.deleteAddress(id);
    }

    @Override
    public List<Address> getAllElements() {
        return addressMapper.getAllAddress();
    }

    @Override
    public Address getElementById(int id) {
        return addressMapper.getAddressById(id);
    }
}
