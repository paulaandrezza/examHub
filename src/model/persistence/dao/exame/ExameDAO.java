package model.persistence.dao.exame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.persistence.dao.GenericDAO;
import model.persistence.dao.interfaces.ICommonDAO;

public class ExameDAO extends GenericDAO<ExameDTO> implements ICommonDAO<ExameDTO> {

	public ExameDAO() {
		super("exame");
	}

	@Override
	public int save(ExameDTO exameDTO) throws SQLException {
		try {
			connection.setAutoCommit(false);
			int exameId = saveExame(exameDTO);

			if (exameDTO instanceof EcocardiogramaDTO) {
				saveEcocardiograma((EcocardiogramaDTO) exameDTO, exameId);
			} else if (exameDTO instanceof EletrocardiogramaDTO) {
				saveEletrocardiograma((EletrocardiogramaDTO) exameDTO, exameId);
			} else if (exameDTO instanceof HolterDTO) {
				saveHolter((HolterDTO) exameDTO, exameId);
			} else if (exameDTO instanceof MapaDTO) {
				saveMapa((MapaDTO) exameDTO, exameId);
			} else if (exameDTO instanceof TesteErgometricoDTO) {
				saveTesteErgometrico((TesteErgometricoDTO) exameDTO, exameId);
			}

			connection.commit();
			return exameId;
		} catch (SQLException e) {
			throw new SQLException("Erro ao salvar exame: " + e.getMessage());
		}
	}

	private int saveExame(ExameDTO exameDTO) throws SQLException {
		String sql = "INSERT INTO exame (agendamento_id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setInt(1, exameDTO.getAgendamento_id());
			statement.setFloat(2, exameDTO.getPeso());
			statement.setInt(3, exameDTO.getMedicoResponsavel_id());
			statement.setString(4, exameDTO.getConclusoes());
			statement.setString(5, exameDTO.getDetalhes());
			statement.setInt(6, exameDTO.getDiagnosticoClinico());

			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating exame failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("Creating exame failed, no ID obtained.");
				}
			}
		}
	}

	private void saveEcocardiograma(EcocardiogramaDTO ecocardiogramaDTO, int exameId) throws SQLException {
		String sql = "INSERT INTO ecocardiograma (raizAorta, atrioEsquerdo, vdDiastolico, veSistolico, vePosterior, septoIntraventricular, fracaoEncurtamento, fracaoEjecao, exame_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, ecocardiogramaDTO.getRaizAorta());
			statement.setInt(2, ecocardiogramaDTO.getAtrioEsquerdo());
			statement.setInt(3, ecocardiogramaDTO.getVdDiastolico());
			statement.setInt(4, ecocardiogramaDTO.getVeSistolico());
			statement.setInt(5, ecocardiogramaDTO.getVePosterior());
			statement.setInt(6, ecocardiogramaDTO.getSeptoIntraventricular());
			statement.setInt(7, ecocardiogramaDTO.getFracaoEncurtamento());
			statement.setFloat(8, ecocardiogramaDTO.getFracaoEjecao());
			statement.setInt(9, exameId);
			statement.executeUpdate();
		}
	}

	private void saveEletrocardiograma(EletrocardiogramaDTO eletrocardiogramaDTO, int exameId) throws SQLException {
		String sql = "INSERT INTO eletrocardiograma (ritmo, fc, ondaP, complexoQRS, eixoEletrico, exame_id) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, eletrocardiogramaDTO.getRitmo());
			statement.setInt(2, eletrocardiogramaDTO.getFc());
			statement.setFloat(3, eletrocardiogramaDTO.getOndaP());
			statement.setInt(4, eletrocardiogramaDTO.getComplexoQRS());
			statement.setInt(5, eletrocardiogramaDTO.getEixoEletrico());
			statement.setInt(6, exameId);
			statement.executeUpdate();
		}
	}

	private void saveHolter(HolterDTO holterDTO, int exameId) throws SQLException {
		String sql = "INSERT INTO holter (arritmia, isquemiaCardiaca, dcIntravicular, dcAtriovencular, apneiaSono, exame_id) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, holterDTO.getArritmia());
			statement.setInt(2, holterDTO.getIsquemiaCardiaca());
			statement.setInt(3, holterDTO.getDcIntravicular());
			statement.setInt(4, holterDTO.getDcAtriovencular());
			statement.setBoolean(5, holterDTO.isApneiaSono());
			statement.setInt(6, exameId);
			statement.executeUpdate();
		}
	}

	private void saveMapa(MapaDTO mapaDTO, int exameId) throws SQLException {
		String sql = "INSERT INTO mapa (mediaHoras, paVirgula, paSono, exame_id) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, mapaDTO.getMediaHoras());
			statement.setString(2, mapaDTO.getPaVirgula());
			statement.setString(3, mapaDTO.getPaSono());
			statement.setInt(4, exameId);
			statement.executeUpdate();
		}
	}

	private void saveTesteErgometrico(TesteErgometricoDTO testeErgometricoDTO, int exameId) throws SQLException {
		String sql = "INSERT INTO testeErgometrico (ritmo, fc, exame_id) VALUES (?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, testeErgometricoDTO.getRitmo());
			statement.setInt(2, testeErgometricoDTO.getFc());
			statement.setInt(3, exameId);
			statement.executeUpdate();
		}
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public ExameDTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
