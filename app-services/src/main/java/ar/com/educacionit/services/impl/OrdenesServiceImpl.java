package ar.com.educacionit.services.impl;

import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.DireccionesOrdenesDao;
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

	private OrdenesItemsDao ordenesDao = new OrdenesItemsJDBCDaoImpl();
	private PagosOrdenesDao pagosOrdenesDao = new PagosOrdenesJDBCDaoImpl();
	private DireccionesOrdenesDao direccionesOrdnesDao = new DireccionesOrdenesJDBCDaoImpl(); 
	
	public OrdenesServiceImpl() {
		super(new OrdenesJDBCDaoImpl());
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
				ordenesDao.save(oi);
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

}
