package ar.com.educacionit.services;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.domain.Categoria;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestCategoria {

	@Order(1)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		CategoriasService cd = new CategoriaServiceImpl();
		List<Categoria> list = cd.findAll();
		System.out.println(list);
	}

}
