package ar.com.educacionit.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.CategoriaJDBCDaoImpl2;
import ar.com.educacionit.domain.Categoria;

@TestMethodOrder(OrderAnnotation.class)
public class TestCategoria2 {

	@Order(1)
	@Test
	public void whenSaveNewEntity_then_showId() throws DuplicatedException, GenericException {
		Categoria entity = new Categoria();
		entity.setDescripcion(Math.random()+ "Celulares"); 
		entity.setHabilitada(1l);
		entity.setCodigo(new String(""+Math.random()).substring(0,9));
		
		CategoriasDao cd = new CategoriaJDBCDaoImpl2();
		cd.save(entity);
		assertNotNull(entity.getId());		
	}
	
	@Order(2)
	@Test
	public void whenGetOne_then_showIt() throws GenericException, DuplicatedException {		
		CategoriasDao cd = new CategoriaJDBCDaoImpl2();
		
		Categoria entity = new Categoria();
		entity.setDescripcion(Math.random() + "Celulares"); 
		entity.setHabilitada(1L);
		entity.setCodigo(new String(""+Math.random()).substring(0,9));

		cd.save(entity);
		
		cd.getOne(entity.getId());
	}
	
	@Order(3)
	@Test
	public void whenFindAll_then_showList() throws GenericException {
		CategoriasDao cd = new CategoriaJDBCDaoImpl2();
		cd.findAll();		
	}
	
	@Order(4)
	@Test
	public void whenExistsCategoria_then_deleteId() throws DuplicatedException, GenericException {
		Categoria entity = new Categoria();
		entity.setDescripcion(Math.random() + "Celulares"); 
		entity.setCodigo(new String(""+Math.random()).substring(0,9));

		CategoriasDao cd = new CategoriaJDBCDaoImpl2();
		cd.save(entity);
		
		cd.delete(entity.getId());		
	}
	
	
	@Order(5)
	@Test
	public void whenExistsCategoria_then_updateIt() throws DuplicatedException, GenericException {
		Categoria entity = new Categoria();
		entity.setDescripcion(Math.random() + "Celulares"); 
		entity.setCodigo(new String(""+Math.random()).substring(0,9));

		CategoriasDao cd = new CategoriaJDBCDaoImpl2();
		cd.save(entity);
		
		String expected = "actualizado";
		
		entity.setDescripcion(expected);
		
		cd.update(entity);
		
		assertEquals(expected, entity.getDescripcion());
	}
		
	@Order(6)
	@Test
	public void whenExistsCategorioas_then_deleteAll() throws GenericException {
		CategoriasDao cd = new CategoriaJDBCDaoImpl2();
		List<Categoria> list = cd.findAll();
		for(Categoria c : list) {
			cd.delete(c.getId());
		}
	}	
}
