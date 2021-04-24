package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.LoginService;

public class LoginServiceImp implements LoginService {

	private UserDao userDao;
	
	public LoginServiceImp() {
		this.userDao = new UserDaoImpl();
	}
	
	@Override
	public User getUserByUserName(String user) throws ServiceException {
		try {
			return this.userDao.getByUserName(user);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
