package ar.com.educacionit.dao.exceptions;

public class DuplicatedException extends Exception {

	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}
}
