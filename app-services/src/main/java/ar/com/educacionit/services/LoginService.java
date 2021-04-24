package ar.com.educacionit.services;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;

public interface LoginService {

	User getUserByUserName(String user) throws ServiceException;
}
