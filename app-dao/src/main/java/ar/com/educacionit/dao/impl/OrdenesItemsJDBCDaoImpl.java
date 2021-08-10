package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.OrdenesItemsDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.OrdenesItems;

public class OrdenesItemsJDBCDaoImpl extends JDBCDAOBase<OrdenesItems> implements OrdenesItemsDao {

	public OrdenesItemsJDBCDaoImpl() {
		super("ordenes_items");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(ordenes_id, numero_item, cantidad, articulos_id,precio_unitario) values(?,?,?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, OrdenesItems entity) throws SQLException {
		pst.setLong(1, entity.getOrdenesId());
		pst.setLong(2, entity.getNumeroItem());
		pst.setLong(3, entity.getCantidad());
		pst.setLong(4, entity.getArticulosId());
		pst.setDouble(5, entity.getPrecioUnitario());
	}

	@Override
	protected String getUpdateSQL() {
		return "";//"descripcion=?, descripcion_corta=?,habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, OrdenesItems entity) throws SQLException {
		/*pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getHabilitada());*/
	}
	
	@Override
	public List<OrdenesItems> findByOrdenesId(Long ordenesId) throws GenericException {
		String sql = "ordenes_id = " +ordenesId;
		List<OrdenesItems> list =  super.findAllBy(sql);
		return list;
	}
}

