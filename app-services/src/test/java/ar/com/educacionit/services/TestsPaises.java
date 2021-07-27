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
import ar.com.educacionit.domain.Paises;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.impl.PaisesServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestsPaises {
		
	@Order(1)
	@Test
	public void whenNew_then_persistsIt() throws ServiceException, DuplicatedException {
		
		//when
		Paises entity = new Paises();
		entity.setDescripcion("pais");
		entity.setDescripcionCorta("pais");
		entity.setHabilitada(1L);
		
		//then	
		PaisesService service = new PaisesServiceImpl();
		service.save(entity);
		
		//assert
		assertNotNull(entity.getId());
	}
	
	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		PaisesService service = new PaisesServiceImpl();
		List<Paises> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		PaisesService service = new PaisesServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		Paises entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(4)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		PaisesService service = new PaisesServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		Paises entity = service.getOne(entityId);
		
		String expected = "actualizado";
		
		entity.setDescripcion(expected);
		entity.setDescripcionCorta(expected.substring(0,5));
		entity.setHabilitada(0L);
		
		service.update(entity);
		
		assertEquals(expected, entity.getDescripcion());
		assertEquals(expected.substring(0,5), entity.getDescripcionCorta() );
		assertEquals(0L,entity.getHabilitada()) ;
	}
	
	@Order(5)
	@Test
	public void whenExistsEntity_then_deleteId() throws ServiceException{		
		PaisesService service = new PaisesServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	
	
}
