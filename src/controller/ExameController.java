package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Funcionario;
import model.entities.Paciente;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.entities.exames.tipos.Ecocardiograma;
import model.entities.exames.tipos.Eletrocardiograma;
import model.entities.exames.tipos.Holter;
import model.entities.exames.tipos.Mapa;
import model.entities.exames.tipos.TesteErgometrico;
import model.enums.EnumDiagnostico;
import model.enums.EnumStatusAgendamento;
import model.enums.EnumTipoExame;
import model.exceptions.EntityNotFoundException;
import model.persistence.dao.exame.EcocardiogramaDTO;
import model.persistence.dao.exame.EletrocardiogramaDTO;
import model.persistence.dao.exame.ExameDAO;
import model.persistence.dao.exame.ExameDTO;
import model.persistence.dao.exame.HolterDTO;
import model.persistence.dao.exame.MapaDTO;
import model.persistence.dao.exame.TesteErgometricoDTO;

public class ExameController implements IController<ExameDTO, Exame> {
	private ExameDAO exameDAO;
	private PacienteController pacienteController;
	private FuncionarioController funcionarioController;

	public ExameController() {
		super();
		this.exameDAO = new ExameDAO();
		this.pacienteController = new PacienteController();
		this.funcionarioController = new FuncionarioController();
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
		Paciente paciente = null;
		List<Paciente> pacientes = pacienteController.searchByField("paciente_id",
				dto.getAgendamentoDTO().getPaciente_id());
		if (!pacientes.isEmpty()) {
			paciente = pacientes.get(0);
			Agendamento agendamento = new Agendamento(dto.getAgendamentoDTO().getDataEhorario(), paciente,
					dto.getAgendamentoDTO().getMedicoSolicitante(),
					EnumStatusAgendamento.fromInt(dto.getAgendamentoDTO().getStatusAgendamento()),
					EnumTipoExame.fromInt(dto.getAgendamentoDTO().getTipoExame()));
		}

		Funcionario medicoResponsavel = funcionarioController.getById(dto.getMedicoResponsavel_id());

		EnumTipoExame enumTipoExame = EnumTipoExame.fromInt(dto.getAgendamentoDTO().getTipoExame());
		Exame exame = null;

		Agendamento agendamento = new Agendamento(dto.getAgendamento_id(), dto.getAgendamentoDTO().getDataEhorario(),
				paciente, dto.getAgendamentoDTO().getMedicoSolicitante(),
				EnumStatusAgendamento.fromInt(dto.getAgendamentoDTO().getStatusAgendamento()), enumTipoExame);

		switch (enumTipoExame) {
		case ECOCARDIOGRAMA:
			EcocardiogramaDTO ecocardiogramaDTO = (EcocardiogramaDTO) dto;
			exame = new Ecocardiograma(ecocardiogramaDTO.getExame_id(), ecocardiogramaDTO.getPeso(), medicoResponsavel,
					ecocardiogramaDTO.getConclusoes(), ecocardiogramaDTO.getDetalhes(),
					EnumDiagnostico.fromInt(ecocardiogramaDTO.getDiagnosticoClinico()), agendamento,
					ecocardiogramaDTO.getId(), ecocardiogramaDTO.getRaizAorta(), ecocardiogramaDTO.getAtrioEsquerdo(),
					ecocardiogramaDTO.getVdDiastolico(), ecocardiogramaDTO.getVeSistolico(),
					ecocardiogramaDTO.getVePosterior(), ecocardiogramaDTO.getSeptoIntraventricular(),
					ecocardiogramaDTO.getFracaoEncurtamento(), ecocardiogramaDTO.getFracaoEjecao());
			break;
		case ELETROCARDIOGRAMA:
			EletrocardiogramaDTO eletrocardiogramaDTO = (EletrocardiogramaDTO) dto;
			exame = new Eletrocardiograma(eletrocardiogramaDTO.getExame_id(), eletrocardiogramaDTO.getPeso(),
					medicoResponsavel, eletrocardiogramaDTO.getConclusoes(), eletrocardiogramaDTO.getDetalhes(),
					EnumDiagnostico.fromInt(eletrocardiogramaDTO.getDiagnosticoClinico()), agendamento,
					eletrocardiogramaDTO.getId(), eletrocardiogramaDTO.getRitmo(), eletrocardiogramaDTO.getFc(),
					eletrocardiogramaDTO.getOndaP(), eletrocardiogramaDTO.getComplexoQRS(),
					eletrocardiogramaDTO.getEixoEletrico());
			break;
		case HOLTER:
			HolterDTO holterDTO = (HolterDTO) dto;
			exame = new Holter(holterDTO.getExame_id(), holterDTO.getPeso(), medicoResponsavel,
					holterDTO.getConclusoes(), holterDTO.getDetalhes(),
					EnumDiagnostico.fromInt(holterDTO.getDiagnosticoClinico()), agendamento, holterDTO.getId(),
					holterDTO.getArritmia(), holterDTO.getIsquemiaCardiaca(), holterDTO.getDcIntravicular(),
					holterDTO.getDcAtriovencular(), holterDTO.isApneiaSono());
			break;
		case MAPA:
			MapaDTO mapaDTO = (MapaDTO) dto;
			exame = new Mapa(mapaDTO.getExame_id(), mapaDTO.getPeso(), medicoResponsavel, mapaDTO.getConclusoes(),
					mapaDTO.getDetalhes(), EnumDiagnostico.fromInt(mapaDTO.getDiagnosticoClinico()), agendamento,
					mapaDTO.getId(), mapaDTO.getMediaHoras(), mapaDTO.getPaVirgula(), mapaDTO.getPaSono());
			break;
		case TESTE_ERGOMETRICO:
			TesteErgometricoDTO testeErgometricoDTO = (TesteErgometricoDTO) dto;
			exame = new TesteErgometrico(testeErgometricoDTO.getExame_id(), testeErgometricoDTO.getPeso(),
					medicoResponsavel, testeErgometricoDTO.getConclusoes(), testeErgometricoDTO.getDetalhes(),
					EnumDiagnostico.fromInt(testeErgometricoDTO.getDiagnosticoClinico()), agendamento,
					testeErgometricoDTO.getId(), testeErgometricoDTO.getRitmo(), testeErgometricoDTO.getFc());
			break;
		default:
			throw new SQLException("Tipo de exame desconhecido: " + enumTipoExame);
		}

		return exame;
	}

	@Override
	public List<Exame> convertDtoListToEntityList(List<ExameDTO> examesDTO)
			throws SQLException, EntityNotFoundException {
		List<Exame> exames = new ArrayList<Exame>();

		for (ExameDTO dto : examesDTO) {
			Exame exame = convertDtoToEntity(dto);
			exames.add(exame);
		}

		return exames;
	}

}
