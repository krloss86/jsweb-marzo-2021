package ar.com.educacionit.dao;

import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.OrdenesItems;

public interface OrdenesItemsDao extends GenericDao<OrdenesItems>{

	List<OrdenesItems> findByOrdenesId(Long id) throws GenericException;

}
