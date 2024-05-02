package model.persistence.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ICommonDAO<T> extends IGenericDAO<T> {
    int save(T t);
    void update(int id, String[] params);
    void delete(int id);
    T convertToEntity(ResultSet resultSet) throws SQLException;
}
