package ar.com.educacionit.services.impl;

import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.DireccionesOrdenesDao;
import ar.com.educacionit.dao.OrdenesDao;
import ar.com.educacionit.dao.OrdenesItemsDao;
import ar.com.educacionit.dao.PagosOrdenesDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.DireccionesOrdenesJDBCDaoImpl;
import ar.com.educacionit.dao.impl.OrdenesItemsJDBCDaoImpl;
import ar.com.educacionit.dao.impl.OrdenesJDBCDaoImpl;
import ar.com.educacionit.dao.impl.PagosOrdenesJDBCDaoImpl;
import ar.com.educacionit.domain.DireccionesOrdenes;
import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.domain.OrdenesItems;
import ar.com.educacionit.domain.PagosOrdenes;
import ar.com.educacionit.domain.dto.ItemCarrito;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.OrdenesService;

public class OrdenesServiceImpl extends AbstractBaseService<Ordenes> implements OrdenesService{

	private OrdenesItemsDao ordenesItemsDao = new OrdenesItemsJDBCDaoImpl();
	private PagosOrdenesDao pagosOrdenesDao = new PagosOrdenesJDBCDaoImpl();
	private DireccionesOrdenesDao direccionesOrdnesDao = new DireccionesOrdenesJDBCDaoImpl(); 
	private PagosOrdenesDao pagoOrdenDao = new PagosOrdenesJDBCDaoImpl();
	
	public OrdenesServiceImpl() {
		super(new OrdenesJDBCDaoImpl());
	}
	
	@Override
	public Ordenes getOne(Long id) throws ServiceException {
		Ordenes orden = super.getOne(id);
		try {
			List<OrdenesItems> items = ordenesItemsDao.findByOrdenesId(orden.getId());
			DireccionesOrdenes direccionOrden = direccionesOrdnesDao.findByOrdenesId(orden.getId());
			PagosOrdenes pagoOrden = pagoOrdenDao.findByOrdenesId(orden.getId());

			orden.setDireccionOrden(direccionOrden);
			orden.setItems(items);
			orden.setPagoOrden(pagoOrden);
		} catch (GenericException e) {
			e.printStackTrace();
		}
		return orden;
	}

	@Override
	public Long save(List<ItemCarrito> items,Long sociosId, Double montoTotal, Long cuponId,Long mediosPagosId, Long paisesId,String direccion) throws ServiceException {	
		Ordenes entity = new Ordenes();
		entity.setCuponesId(cuponId);
		entity.setEstadosOrdenesId(1L);
		entity.setFechaCreacion(new Date());
		entity.setMontoTotal(montoTotal);
		entity.setSociosId(sociosId);
		
		try {
			this.dao.save(entity);
			
			//ahora grabo los items
			long i = 0;
			for(ItemCarrito item : items) {
				OrdenesItems oi = new OrdenesItems();
				oi.setOrdenesId(entity.getId());
				oi.setArticulosId(item.getId());
				oi.setCantidad(cuponId);
				oi.setCantidad(new Long(item.getCantidad()));
				oi.setNumeroItem(i);
				oi.setPrecioUnitario(item.getPrecio());
				ordenesItemsDao.save(oi);
				i++;
			}
			
			//pago orden
			PagosOrdenes po = new PagosOrdenes();
			po.setFechaPago(new Date());
			po.setMediosPagosId(mediosPagosId);
			po.setMonto(montoTotal);
			po.setOrdenesId(entity.getId());
			
			this.pagosOrdenesDao.save(po);
			
			//direcciones_ordenes
			DireccionesOrdenes dor = new DireccionesOrdenes();
			dor.setDireccionEnvio(direccion);
			dor.setOrdenesId(entity.getId());
			dor.setPaisesId(paisesId);
			
			this.direccionesOrdnesDao.save(dor);
			
			return entity.getId();
		} catch (DuplicatedException e) {
			throw new ServiceException(e.getMessage(),e);
		} catch (GenericException e) {			
			throw new ServiceException(e);
		}		
	}

	@Override
	public List<Ordenes> findAllBySocioId(Long socioId) throws ServiceException {
		try {
			//como no es un metodo del generic, debo castear a ArticulosDao
			return ((OrdenesDao)super.dao).findAllBySocioId(socioId);
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(),e);
		}
	}

}
