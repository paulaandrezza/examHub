package controller;

import java.sql.SQLException;

import model.entities.Funcionario;
import model.entities.Pessoa;
import model.enums.EnumGenero;
import model.enums.EnumTipoFuncionario;
import model.exceptions.EntityNotFoundException;
import model.persistence.dao.auth.FuncionarioDTO;
import model.persistence.dao.funcionario.FuncionarioDAO;

public class FuncionarioController {
	private FuncionarioDAO funcionarioDAO;

	public FuncionarioController() {
		this.funcionarioDAO = new FuncionarioDAO();
	}

	public Funcionario getById(int id) throws SQLException, EntityNotFoundException {
		return convertDtoToEntity(funcionarioDAO.findByField("funcionario_id", id, null).get(0));
	}

	public Funcionario convertDtoToEntity(FuncionarioDTO dto) throws SQLException, EntityNotFoundException {
		Pessoa pessoa = new Pessoa(dto.getPessoa_id(), dto.getPessoa().getNome(), dto.getPessoa().getCpf(),
				dto.getPessoa().getRg(), dto.getPessoa().getDataNascimento(), dto.getPessoa().getCelular(),
				dto.getPessoa().getTelefone(), dto.getPessoa().getEmail(),
				EnumGenero.fromInt(dto.getPessoa().getGenero()));

		return new Funcionario(dto.getId(), dto.getEmailCorporativo(),
				EnumTipoFuncionario.fromInt(dto.getTipoFuncionario()), pessoa);
	}

}
