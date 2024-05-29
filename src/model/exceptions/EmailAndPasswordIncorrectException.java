package model.exceptions;

public class EmailAndPasswordIncorrectException extends Exception {
	public EmailAndPasswordIncorrectException() {
		super("Email e/ou senha incorretos!");
	}
}
