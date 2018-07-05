package book.dao;

import java.util.List;

public interface BaseDao<T> {
    public boolean add(T t);
    public boolean update(T t);
    public boolean delete(int id);
    public List<T> getAllElements();
    public T getElementById(int id);

}
