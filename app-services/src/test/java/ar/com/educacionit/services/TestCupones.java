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
import ar.com.educacionit.domain.Cupones;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CuponesServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestCupones {
		
	@Order(1)
	@Test
	public void whenNew_then_persistsIt() throws ServiceException, DuplicatedException {
		
		//when
		Cupones entity = new Cupones();
		entity.setCodigo(new String(""+Math.random()).substring(0,5));
		entity.setDescuento(50d);
		entity.setFechaVigenciaDesde(new Date());
		entity.setFechaVigenciaHasta(new Date());
		entity.setNombre("cupon1");
		
		//then	
		CuponesService service = new CuponesServiceImpl();
		service.save(entity);
		
		//assert
		assertNotNull(entity.getId());
	}
	
	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		CuponesService service = new CuponesServiceImpl();
		List<Cupones> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		CuponesService service = new CuponesServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		Cupones entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(4)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		CuponesService service = new CuponesServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		Cupones entity = service.getOne(entityId);
		
		String expected = "actualizado";
		
		entity.setCodigo(expected.substring(0,5));
		entity.setDescuento(60d);
		Date newDate = new Date();
		entity.setFechaVigenciaDesde(newDate);
		entity.setFechaVigenciaHasta(newDate);
		entity.setNombre(expected);
		
		service.update(entity);
		
		assertEquals(expected.substring(0,5), entity.getCodigo());
		assertEquals(60F, entity.getDescuento());
		assertEquals(newDate,entity.getFechaVigenciaDesde()) ;
		assertEquals(newDate,entity.getFechaVigenciaHasta()) ;
	}
	
	@Order(5)
	@Test
	public void whenExistsEntity_then_deleteId() throws ServiceException{		
		CuponesService service = new CuponesServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	
	
}
