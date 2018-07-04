package book.dao;

public interface BaseDao<T> {
    public boolean add(T t);
    public T getElementById(int id);
}
