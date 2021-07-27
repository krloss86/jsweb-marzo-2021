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
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.impl.SociosServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestSocios {
		
	@Order(1)
	@Test
	public void whenNew_then_persistsIt() throws ServiceException, DuplicatedException {
		
		//when
		Socios entity = new Socios();
		entity.setApellido("apelido");
		entity.setNombre("nombre");
		entity.setEmail(Math.random()+"@email1.com");
		entity.setFechaAlta(new Date());
		
		//then	
		SociosService service = new SociosServiceImpl();
		service.save(entity);
		
		//assert
		assertNotNull(entity.getId());
	}
	
	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		SociosService service = new SociosServiceImpl();
		List<Socios> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		SociosService service = new SociosServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		Socios entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(4)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		SociosService service = new SociosServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		Socios entity = service.getOne(entityId);
		
		String expected = "actualizado";
		
		entity.setNombre(expected);
		entity.setApellido(expected);
		entity.setEmail(expected);
		
		service.update(entity);
		
		assertEquals(expected, entity.getApellido());
		assertEquals(expected, entity.getNombre());
		assertEquals(expected, entity.getEmail());
	}
	
	@Order(5)
	@Test
	public void whenExistsEntity_then_deleteId() throws ServiceException{		
		SociosService service = new SociosServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	
	
}
