package ar.com.educacionit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.impl.MarcasServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestMarcas {
		
	@Order(1)
	@Test
	public void whenNew_then_persistsIt() throws ServiceException, DuplicatedException {
		
		//when
		Marcas entity = new Marcas();
		entity.setCodigo(new String(""+Math.random()).substring(0,5));
		entity.setDescripcion("marca1");
		entity.setHabilitada(1L);
		
		//then	
		MarcasService service = new MarcasServiceImpl();
		service.save(entity);
		
		//assert
		assertNotNull(entity.getId());
	}
	
	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		MarcasService service = new MarcasServiceImpl();
		List<Marcas> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		MarcasService service = new MarcasServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		Marcas entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(4)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		MarcasService service = new MarcasServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		Marcas entity = service.getOne(entityId);
		
		String expected = "actualizado";
		
		entity.setCodigo(expected.substring(0,5));
		entity.setDescripcion(expected);
		entity.setHabilitada(0L);
		
		service.update(entity);
		
		assertEquals(expected.substring(0,5), entity.getCodigo() );
		assertEquals(expected, entity.getDescripcion());
		assertEquals(0L,entity.getHabilitada()) ;
	}
	
	@Order(5)
	@Test
	public void whenExistsEntity_then_deleteId() throws ServiceException{		
		MarcasService service = new MarcasServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	
	
}
