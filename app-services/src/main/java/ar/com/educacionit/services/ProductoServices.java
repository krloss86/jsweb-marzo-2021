package ar.com.educacionit.services;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public interface ProductoServices {

	Collection<Producto> findAll() throws ServiceException;
}
