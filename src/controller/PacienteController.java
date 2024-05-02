package controller;

import java.util.List;

import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.HistoricoMedico;
import model.entities.Paciente;
import model.entities.Pessoa;
import model.persistence.dao.paciente.PacienteDAO;
import model.persistence.dao.paciente.PacienteFullDTO;

public class PacienteController implements IController<PacienteFullDTO, Paciente> {
	private PacienteDAO pacienteDao;

	public PacienteController() {
		this.pacienteDao = new PacienteDAO();
	}

	@Override
	public void create(PacienteFullDTO dto) {
		Paciente paciente = convertDtoToEntity(dto);
		try {
			pacienteDao.save(paciente);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar paciente: " + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Paciente get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente convertDtoToEntity(PacienteFullDTO dto) {
		Endereco endereco = new Endereco(dto.getCep(), dto.getEstado(), dto.getCidade(), dto.getBairro(), dto.getRua(),
				dto.getNumero(), dto.getComplemento());

		Pessoa pessoa = new Pessoa(dto.getNome(), dto.getCpf(), dto.getDataNascimento(), dto.getCelular(),
				dto.getTelefone(), dto.getEmail(), dto.getGenero(), endereco);

		Convenio convenio = new Convenio(dto.getNumeroCarteirinha(), dto.getPrestadora(), dto.getPlano());

		HistoricoMedico historicoMedico = new HistoricoMedico(dto.getAlergias(), dto.getMedicamentos(),
				dto.getPrescricao());

		Paciente paciente = new Paciente(dto.getAltura(), dto.isFumante(), dto.isMarcaPasso(), convenio,
				historicoMedico, pessoa);

		return paciente;
	}
}
