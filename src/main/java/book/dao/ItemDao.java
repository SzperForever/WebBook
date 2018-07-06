package book.dao;

import book.mapper.ItemMapper;
import book.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao implements BaseDao<Item> {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public boolean add(Item item) {
        return itemMapper.insertItem(item);
    }

    @Override
    public boolean update(Item item) {
        return itemMapper.updateItem(item);
    }

    @Override
    public boolean delete(int id) {
        return itemMapper.deleteItem(id);
    }

    @Override
    public List<Item> getAllElements() {
        return itemMapper.getAllItem();
    }

    @Override
    public Item getElementById(int id) {
        return itemMapper.getItemById(id);
    }
}
