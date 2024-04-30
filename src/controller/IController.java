package controller;

import java.util.List;

public interface IController<T> {
	void create(T entity);
    void update(T entity);
    void delete(int id);
    T get(int id);
    List<T> getAll();
}
