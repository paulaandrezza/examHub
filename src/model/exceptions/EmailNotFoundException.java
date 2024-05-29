package model.exceptions;

public class EmailNotFoundException extends Exception {
	public EmailNotFoundException(String email) {
		super("Email " + email + " não foi encontrada na base de dados ");
	}
}
