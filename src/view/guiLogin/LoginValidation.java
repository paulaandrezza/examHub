package view.guiLogin;

import javax.swing.JOptionPane;

import controller.AuthController;
import model.enums.EnumTipoFuncionario;
import model.exceptions.EmailAndPasswordIncorrectException;
import view.guiMenu.MenuPanel;

public class LoginValidation {
	private AuthController authController = new AuthController();
	private String email;
	private String senha;

	public LoginValidation(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public void run() {
		try {
			EnumTipoFuncionario tipoFuncionario = authController.auth(email, senha);
			MenuPanel tela = new MenuPanel();
			tela.setVisible(true);
		} catch (EmailAndPasswordIncorrectException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
}