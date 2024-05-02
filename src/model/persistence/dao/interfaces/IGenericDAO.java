package model.persistence.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<DTO> {
	List<DTO> getAll();

	List<DTO> findByField(String fieldName, Object fieldValue) throws SQLException;

	<E> int save(E entity, String tableName) throws SQLException;
}
