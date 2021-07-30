package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import ar.com.educacionit.dao.OrdenesDao;
import ar.com.educacionit.domain.Ordenes;

public class OrdenesJDBCDaoImpl extends JDBCDAOBase<Ordenes> implements OrdenesDao {

	public OrdenesJDBCDaoImpl() {
		super("ordenes");
	}

	@Override
	protected void update(PreparedStatement pst, Ordenes entity) throws SQLException {
		pst.setLong(1,entity.getEstadosOrdenesId());
		pst.setDouble(2, entity.getMontoTotal());
		if(entity.getCuponesId() != null) {
			pst.setLong(3,entity.getCuponesId());
		}else {
			pst.setNull(3, Types.INTEGER);
		}
	}

	@Override
	protected String getUpdateSQL() {		
		return "estados_ordenes_id=?, monto_total=?, cupones_id=?";
	}

	@Override
	protected void save(PreparedStatement pst, Ordenes entity) throws SQLException {
		pst.setDate(1, new java.sql.Date(entity.getFechaCreacion().getTime()));
		//convierto java.util.data a java.sql.Date
		pst.setLong(2, entity.getSociosId());
		pst.setLong(3,entity.getEstadosOrdenesId());
		pst.setDouble(4, entity.getMontoTotal());
		if(entity.getCuponesId() != null) {
			pst.setLong(5,entity.getCuponesId());
		}else {
			pst.setNull(5, Types.INTEGER);
		}
	}

	@Override
	protected String getSaveSQL() {
		return "(fecha_creacion,socios_id,estados_ordenes_id,monto_total,cupones_id) values (?,?,?,?,?)";
	}

}
