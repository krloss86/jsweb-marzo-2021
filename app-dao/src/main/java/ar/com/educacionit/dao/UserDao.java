package ar.com.educacionit.dao;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.User;

public interface UserDao {

	public User getByUserName(String user) throws GenericException;

}
