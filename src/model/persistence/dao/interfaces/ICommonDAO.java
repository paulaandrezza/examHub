package model.persistence.dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICommonDAO<DTO> {
	int save(DTO dto) throws SQLException;

	List<DTO> getAll(String table);

	void update(int id, String[] params);

	DTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException;
}
