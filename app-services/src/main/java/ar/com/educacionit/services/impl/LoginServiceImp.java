package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.SociosJDBCDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.LoginService;

public class LoginServiceImp implements LoginService {

	private UserDao userDao;
	private SociosDao socioDao;
	
	public LoginServiceImp() {
		this.userDao = new UserDaoImpl();
		this.socioDao = new SociosJDBCDaoImpl();
	}
	
	@Override
	public User getUserByUserName(String user) throws ServiceException {
		try {
			User users = this.userDao.getByUserName(user);
			Socios socios = this.socioDao.getSocioByUserId(users.getId());
			users.setSocios(socios);
			return users;
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}

}
