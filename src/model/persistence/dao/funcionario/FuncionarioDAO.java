package model.persistence.dao.funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.persistence.dao.GenericDAO;
import model.persistence.dao.auth.FuncionarioDTO;
import model.persistence.dao.interfaces.ICommonDAO;

public class FuncionarioDAO extends GenericDAO<FuncionarioDTO> implements ICommonDAO<FuncionarioDTO> {

	public FuncionarioDAO() {
		super("funcionario");
	}

	@Override
	public int save(FuncionarioDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public FuncionarioDTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException {
		int pessoaId = resultSet.getInt("pessoa_id");
		String nome = resultSet.getString("nome");
		String cpf = resultSet.getString("cpf");
		String rg = resultSet.getString("rg");
		Object dbSqlDate = resultSet.getObject("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(dbSqlDate.toString());
		long celular = resultSet.getLong("celular");
		long telefone = resultSet.getLong("telefone");
		String email = resultSet.getString("email");
		int generoId = resultSet.getInt("genero");
		int enderecoId = resultSet.getInt("endereco_id");
		int funcionarioId = resultSet.getInt("funcionario_id");
		String emailCorporativo = resultSet.getString("emailCorporativo");
		String senha = resultSet.getString("senha");
		int tipoFuncionarioId = resultSet.getInt("tipoFuncionario");

		PessoaDTO pessoaDTO = new PessoaDTO(pessoaId, nome, cpf, rg, dataNascimento, celular, telefone, email, generoId,
				enderecoId);

		return new FuncionarioDTO(funcionarioId, emailCorporativo, senha, tipoFuncionarioId, pessoaId, pessoaDTO);
	}

}
