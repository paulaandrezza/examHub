package model.persistence.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T> {
	Optional<T> get(int id);
    List<T> getAll();
    int save(T t);
    void update(int id, String[] params);
    void delete(int id);
}
