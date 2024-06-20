package controller;

import java.sql.SQLException;
import java.util.List;

import model.exceptions.EntityNotFoundException;

public interface IController<DTO, Entity> {
	int create(DTO dto) throws Exception;

	// void update(T entity);
	// void delete(int id);

	List<Entity> searchByField(String fieldName, Object fieldValue) throws SQLException, EntityNotFoundException;

	List<Entity> getAll() throws SQLException, EntityNotFoundException;

	Entity convertDtoToEntity(DTO dto) throws SQLException, EntityNotFoundException;

	List<Entity> convertDtoListToEntityList(List<DTO> dto) throws SQLException, EntityNotFoundException;
}
