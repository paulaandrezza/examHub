package model.persistence.dao.exame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import model.enums.EnumTipoExame;
import model.persistence.dao.GenericDAO;
import model.persistence.dao.agendamento.AgendamentoDTO;
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
		int agendamentoId = resultSet.getInt("agendamento_id");
		Object dbSqlDate = resultSet.getObject("dataEhorario");
		LocalDateTime dataEhorario = LocalDateTime.parse(dbSqlDate.toString());
		int paciente_id = resultSet.getInt("paciente_id");
		String medicoSolicitante = resultSet.getString("medicoSolicitante");
		int statusAgendamento = resultSet.getInt("statusAgendamento");
		int tipoExame = resultSet.getInt("tipoExame");

		AgendamentoDTO agendamentoDTO = new AgendamentoDTO(agendamentoId, dataEhorario, paciente_id, medicoSolicitante,
				statusAgendamento, tipoExame);

		int exameId = resultSet.getInt("exame_id");
		float peso = resultSet.getFloat("peso");
		int medicoResponsavelId = resultSet.getInt("medicoResponsavel_id");
		String conclusoes = resultSet.getString("conclusoes");
		String detalhes = resultSet.getString("detalhes");
		int diagnosticoClinico = resultSet.getInt("diagnosticoClinico");

		EnumTipoExame enumTipoExame = EnumTipoExame.fromInt(tipoExame);
		ExameDTO exameDTO = null;

		switch (enumTipoExame) {
		case ECOCARDIOGRAMA:
			int ecocardiogramaId = resultSet.getInt("ecocardiograma_id");
			int raizAorta = resultSet.getInt("raizAorta");
			int atrioEsquerdo = resultSet.getInt("atrioEsquerdo");
			int vdDiastolico = resultSet.getInt("vdDiastolico");
			int veSistolico = resultSet.getInt("veSistolico");
			int vePosterior = resultSet.getInt("vePosterior");
			int septoIntraventricular = resultSet.getInt("septoIntraventricular");
			int fracaoEncurtamento = resultSet.getInt("fracaoEncurtamento");
			float fracaoEjecao = resultSet.getFloat("fracaoEjecao");
			exameDTO = new EcocardiogramaDTO(peso, medicoResponsavelId, conclusoes, detalhes, diagnosticoClinico,
					agendamentoId, agendamentoDTO, ecocardiogramaId, raizAorta, atrioEsquerdo, vdDiastolico,
					veSistolico, vePosterior, septoIntraventricular, fracaoEncurtamento, fracaoEjecao, exameId);
			break;
		case ELETROCARDIOGRAMA:
			int eletrocardiogramaId = resultSet.getInt("eletrocardiograma_id");
			String ritmo = resultSet.getString("ritmo");
			int fc = resultSet.getInt("fc");
			float ondaP = resultSet.getFloat("ondaP");
			int complexoQRS = resultSet.getInt("complexoQRS");
			int eixoEletrico = resultSet.getInt("eixoEletrico");
			exameDTO = new EletrocardiogramaDTO(peso, medicoResponsavelId, conclusoes, detalhes, diagnosticoClinico,
					agendamentoId, agendamentoDTO, eletrocardiogramaId, ritmo, fc, ondaP, complexoQRS, eixoEletrico,
					exameId);
			break;
		case HOLTER:
			int holterId = resultSet.getInt("holter_id");
			int arritmia = resultSet.getInt("arritmia");
			int isquemiaCardiaca = resultSet.getInt("isquemiaCardiaca");
			int dcIntravicular = resultSet.getInt("dcIntravicular");
			int dcAtriovencular = resultSet.getInt("dcAtriovencular");
			boolean apneiaSono = resultSet.getBoolean("apneiaSono");
			exameDTO = new HolterDTO(peso, medicoResponsavelId, conclusoes, detalhes, diagnosticoClinico, agendamentoId,
					agendamentoDTO, holterId, arritmia, isquemiaCardiaca, dcIntravicular, dcAtriovencular, apneiaSono,
					exameId);
			break;
		case MAPA:
			int mapaId = resultSet.getInt("mapa_id");
			String mediaHoras = resultSet.getString("mediaHoras");
			String paVirgula = resultSet.getString("paVirgula");
			String paSono = resultSet.getString("paSono");
			exameDTO = new MapaDTO(peso, medicoResponsavelId, conclusoes, detalhes, diagnosticoClinico, agendamentoId,
					agendamentoDTO, mapaId, mediaHoras, paVirgula, paSono, exameId);
			break;
		case TESTE_ERGOMETRICO:
			int testeErgometricoId = resultSet.getInt("testeErgometrico_id");
			int ritmoTeste = resultSet.getInt("testeErgometrico_ritmo");
			int fcTeste = resultSet.getInt("testeErgometrico_fc");
			exameDTO = new TesteErgometricoDTO(peso, medicoResponsavelId, conclusoes, detalhes, diagnosticoClinico,
					agendamentoId, agendamentoDTO, testeErgometricoId, ritmoTeste, fcTeste, exameId);
			break;
		default:
			throw new SQLException("Tipo de exame desconhecido: " + enumTipoExame);
		}
		return exameDTO;
	}

}
