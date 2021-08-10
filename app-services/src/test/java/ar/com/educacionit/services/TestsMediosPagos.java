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
import ar.com.educacionit.domain.MediosPagos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.impl.MediosPagosServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestsMediosPagos{
		
	@Order(1)
	@Test
	public void whenNew_then_persistsIt() throws ServiceException, DuplicatedException {
		
		//when
		MediosPagos entity = new MediosPagos();
		entity.setDescripcion("efectivo contrareembolso");
		entity.setDescripcionCorta("efectivo");
		entity.setHabilitada(1L);
		entity.setCodigo("EFE");
		
		//then	
		MediosPagosService service = new MediosPagosServiceImpl();
		service.save(entity);
		
		//assert
		assertNotNull(entity.getId());
	}
	
	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		MediosPagosService service = new MediosPagosServiceImpl();
		List<MediosPagos> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		MediosPagosService service = new MediosPagosServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		MediosPagos entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(4)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		MediosPagosService service = new MediosPagosServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		MediosPagos entity = service.getOne(entityId);
		
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
		MediosPagosService service = new MediosPagosServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	
	
}
