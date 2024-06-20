package model.persistence.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import model.exceptions.EntityNotFoundException;

public interface IGenericDAO<DTO> {
	List<DTO> getAll(String table);

	List<DTO> findByField(String fieldName, Object fieldValue, String table) throws SQLException;

	DTO getById(int id) throws SQLException, EntityNotFoundException;

	<E> int save(E entity, String tableName) throws SQLException;

	void delete(int id) throws SQLException;
}
