package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.domain.Ordenes;
import ar.com.educacionit.domain.dto.ItemCarrito;
import ar.com.educacionit.exceptions.ServiceException;

public interface OrdenesService extends GenericService<Ordenes>{

	public Long save(List<ItemCarrito> items,Long sociosId, Double montoTotal, Long cuponId,Long mediosPagosId, Long paisesId,String direccion) throws ServiceException;
}
