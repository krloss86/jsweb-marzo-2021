package ar.com.educacionit.dao;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Socios;

public interface SociosDao extends GenericDao<Socios>{

	public Socios getSocioByUserId(Long usersId) throws GenericException;
}
