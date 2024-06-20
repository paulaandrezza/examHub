package controller;

import java.sql.SQLException;
import java.util.List;

import model.entities.exames.Exame;
import model.exceptions.EntityNotFoundException;
import model.persistence.dao.exame.ExameDAO;
import model.persistence.dao.exame.ExameDTO;

public class ExameController implements IController<ExameDTO, Exame> {
	private ExameDAO exameDAO;

	public ExameController() {
		this.exameDAO = new ExameDAO();
	}

	@Override
	public int create(ExameDTO dto) throws Exception {
		try {
			return exameDAO.save(dto);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Exame> searchByField(String fieldName, Object fieldValue) throws SQLException, EntityNotFoundException {
		try {
			List<ExameDTO> exameDTO = exameDAO.findByField(fieldName, fieldValue, "ecocardiograma");
			return convertDtoListToEntityList(exameDTO);
		} catch (SQLException e) {
			System.err.println("Erro ao buscar exames: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Exame getById(int id) throws SQLException, EntityNotFoundException {
		return convertDtoToEntity(exameDAO.getById(id));
	}

	@Override
	public List<Exame> getAll() throws SQLException, EntityNotFoundException {
		List<ExameDTO> exameDTO = exameDAO.getAll(null);

		return convertDtoListToEntityList(exameDTO);
	}

	@Override
	public Exame convertDtoToEntity(ExameDTO dto) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Exame> convertDtoListToEntityList(List<ExameDTO> dto) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
