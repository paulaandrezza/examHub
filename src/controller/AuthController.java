package controller;

import java.sql.SQLException;

import model.enums.EnumTipoFuncionario;
import model.exceptions.EmailAndPasswordIncorrectException;
import model.exceptions.EmailNotFoundException;
import model.persistence.dao.auth.AuthDAO;
import model.persistence.dao.auth.FuncionarioDTO;

public class AuthController {
	private AuthDAO authDao;

	public AuthController() {
		this.authDao = new AuthDAO();
	}

	public EnumTipoFuncionario auth(String emailCorporativo, String senha) throws Exception {
		try {
			FuncionarioDTO funcionarioDTO = getPessoa(emailCorporativo);
			if (senha.equals(funcionarioDTO.getSenha()))
				return EnumTipoFuncionario.fromInt(funcionarioDTO.getTipoFuncionario());
			else
				throw new EmailAndPasswordIncorrectException();
		} catch (EmailNotFoundException | EmailAndPasswordIncorrectException e) {
			throw new EmailAndPasswordIncorrectException();
		} catch (SQLException e) {
			throw e;
		}

	}

	private FuncionarioDTO getPessoa(String emailCorporativo) throws Exception {
		try {
			return authDao.getPessoa(emailCorporativo);
		} catch (EmailNotFoundException | SQLException e) {
			throw e;
		}
	}
}
