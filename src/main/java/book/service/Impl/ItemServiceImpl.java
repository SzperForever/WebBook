package book.service.Impl;

import book.dao.ItemDao;
import book.model.Item;
import book.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;

    @Override
    public boolean addItem(int orderId, int bookId, int num) {
        return itemDao.insertItem(Item.getNewInstance(orderId,bookId,num));
    }
}
