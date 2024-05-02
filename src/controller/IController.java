package controller;

import java.util.List;

import model.entities.Paciente;

public interface IController<DTO, Entity> {
	void create(DTO dto);

	// void update(T entity);
	void delete(int id);

	List<Paciente> searchByField(String fieldName, Object fieldValue);

	List<Entity> getAll();

	Entity convertDtoToEntity(DTO dto);

	List<Entity> convertDtoListToEntityList(List<DTO> dto);
}
