package ar.com.educacionit.dao.exceptions;

public class GenericException extends Exception {
	
	public GenericException(Throwable cause) {
		super(cause);
	}

	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}
}
