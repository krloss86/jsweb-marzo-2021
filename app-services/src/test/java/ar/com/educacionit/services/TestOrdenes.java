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
import ar.com.educacionit.domain.EstadosOrdenes;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.EstadosOrdenesServiceImpl;
import ar.com.educacionit.services.impl.MarcasServiceImpl;
import ar.com.educacionit.services.impl.OrdenesServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class TestOrdenes {
		
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
		Articulos articuloEntity = new Articulos();
		articuloEntity.setTitulo("Titulo 1");
		articuloEntity.setCodigo(new String(""+Math.random()).substring(0,10));
		articuloEntity.setFechaCreacion(new Date());
		articuloEntity.setMarcasId(marca.getId());
		articuloEntity.setPrecio(1000d);
		articuloEntity.setStock(10l);
		articuloEntity.setCategoriasId(categoria.getId());
		
		//then	
		ArticulosService service = new ArticuloServiceImpl();
		service.save(articuloEntity);
		
		SociosService sc = new SociosServiceImpl();
		Socios s = sc.findAll().get(0);
		
		EstadosOrdenesService eos = new EstadosOrdenesServiceImpl();
		EstadosOrdenes eo = eos.findAll().get(0);
		
		Ordenes entity = new Ordenes();
		entity.setCuponesId(null);
		entity.setEstadosOrdenesId(eo.getId());
		entity.setFechaCreacion(new Date());
		entity.setMontoTotal(1500.5d);
		entity.setSociosId(s.getId());
		
		OrdenesService os = new OrdenesServiceImpl();
		os.save(entity);
		
		//assert
		assertNotNull(entity.getId());
		
		service.delete(articuloEntity.getId());
	}

	@Order(2)
	@Test
	public void whenFindAll_then_showList() throws ServiceException {
		OrdenesService service = new OrdenesServiceImpl();
		List<Ordenes> entities = service.findAll();
		assertTrue(!entities.isEmpty());
	}
	
	@Order(3)
	@Test
	public void whenGetOne_then_showIt() throws ServiceException {
		OrdenesService service = new OrdenesServiceImpl();
		
		Long entityId = service.findAll().get(0).getId();
		Ordenes entity = service.getOne(entityId);
		
		assertEquals(entityId, entity.getId());
	}

	@Order(4)
	@Test
	public void whenExistsEntity_then_updateIt() throws ServiceException, DuplicatedException {
		OrdenesService service = new OrdenesServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		
		Ordenes entity = service.getOne(entityId);
		
		Double expected = 2360d;
		
		entity.setMontoTotal(expected);
		
		service.update(entity);
		
		assertEquals(expected, entity.getMontoTotal());
	}
	
	@Order(5)
	@Test
	public void whenExistsEntity_then_deleteId() throws ServiceException{		
		OrdenesService service = new OrdenesServiceImpl();
		Long entityId = service.findAll().get(0).getId();
		service.delete(entityId);		
	}	

}
