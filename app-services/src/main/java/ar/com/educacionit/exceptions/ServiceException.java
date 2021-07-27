package ar.com.educacionit.exceptions;

import ar.com.educacionit.dao.exceptions.GenericException;

public class ServiceException extends Exception {

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(GenericException e) {
		super(e);
	}

}
