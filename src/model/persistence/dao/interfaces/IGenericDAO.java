package model.persistence.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<DTO> {
	List<DTO> getAll(String table);

	List<DTO> findByField(String fieldName, Object fieldValue, String table) throws SQLException;

	<E> int save(E entity, String tableName) throws SQLException;

	void update(String tableName, String fieldName, Object fieldValue, int id) throws SQLException;

//	void delete(int id, String tableName) throws SQLException;
}
