package model.persistence.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICommonDAO<DTO, Entity> {
	int save(Entity entity);

	List<DTO> getAll();

	void update(int id, String[] params);

	void delete(int id);

	DTO convertResultSetToEntity(ResultSet resultSet) throws SQLException;
}
