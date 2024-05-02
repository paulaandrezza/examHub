package controller;

import java.util.List;

public interface IController<DTO, Entity> {
	void create(DTO dto);

	// void update(T entity);
	void delete(int id);

	Entity get(int id);

	List<Entity> getAll();

	Entity convertDtoToEntity(DTO dto);
}
