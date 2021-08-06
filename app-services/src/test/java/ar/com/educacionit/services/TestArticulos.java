package ar.com.educacionit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categoria;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.MarcasServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestArticulos {
		
	@Order(1)
	@Test
	public void whenNew_then_persistsIt() throws ServiceException, DuplicatedException {
		
		CategoriasService cs = new CategoriaServiceImpl();
		List<Categoria> categorias = cs.findAll();
		Categoria categoria = categorias.get(0);
		
		MarcasService ms = new MarcasServiceImpl();
		List<Marcas> marcas = ms.findAll();		
		Marcas marca = marcas.get(0);
		
		//when
		Articulos entity = new Articulos();
		entity.setTitulo("Titulo 1");
		entity.setCodigo(new String(""+Math.random()).substring(0,10));
		entity.setFechaCreacion(new Date());
		entity.setMarcasId(marca.getId());
		entity.setPrecio(1000d);
		entity.setStock(10l);
		entity.setCategoriasId(categoria.getId());
		
		//then	
		ArticulosService service = new ArticuloServiceImpl();
		service.save(entity);
		
		//assert
		assertNotNull(entity.getId());
	}
	
	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		ArticulosService service = new ArticuloServiceImpl();
		List<Articulos> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenFindAllWithWhere_then_showList() throws ServiceException {
		ArticulosService service = new ArticuloServiceImpl();
		List<Articulos> entities = service.findAllBy("Titulo");
		assertTrue(!entities.isEmpty());
	}
	
	@Order(4)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		ArticulosService service = new ArticuloServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		Articulos entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(5)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		ArticulosService service = new ArticuloServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		Articulos entity = service.getOne(entityId);
		
		String expected = "actualizado";
		
		entity.setTitulo(expected);
		
		service.update(entity);
		
		assertEquals(expected, entity.getTitulo());
	}

	@Order(6)
	@Test
	public void whenFindAllBy_then_showList() throws ServiceException {
		ArticulosService service = new ArticuloServiceImpl();
		List<Articulos> entities = service.findByCategoriaId(1L);
		assertTrue(!entities.isEmpty());
	}
	
	@Order(7)
	@Test
	public void whenExistsEntity_then_deleteId() throws ServiceException{		
		ArticulosService service = new ArticuloServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	
	
}
