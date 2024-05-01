package model.persistence.dao.interfaces;

import java.util.List;
import java.util.Optional;

import model.exceptions.EntityNotFoundException;

public interface IGenericDAO<T> {
	T get(int id) throws EntityNotFoundException;
    List<T> getAll();
    int save(T t);
    void update(int id, String[] params);
    void delete(int id);
}
