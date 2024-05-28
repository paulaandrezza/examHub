package service.exception;

public class ViaCEPException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViaCEPException(String message) {
		super(message);
	}

	public ViaCEPException(String message, Throwable cause) {
		super(message, cause);
	}
}
