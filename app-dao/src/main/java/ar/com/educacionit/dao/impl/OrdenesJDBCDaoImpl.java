package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.OrdenesDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.Articulos;
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
	/*
	@Override
	public List<Articulos> findAllBy(String titulo) throws GenericException {
		String sql = "titulo like '%"+titulo+"%'";
		return super.findAllBy(sql);
	}*/
	
	@Override
	public List<Ordenes> findAllBySocioId(Long socioId) throws GenericException {
		String sql = "socios_id = " +socioId;
		return super.findAllBy(sql);
	}
}
