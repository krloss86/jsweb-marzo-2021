package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.CuponesDao;
import ar.com.educacionit.domain.Cupones;

public class CuponesJDBCDaoImpl extends JDBCDAOBase<Cupones> implements CuponesDao {

	public CuponesJDBCDaoImpl() {
		super("cupones");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(nombre,codigo,fecha_vigencia_desde,fecha_vigencia_hasta, descuento) values(?,?,?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, Cupones entity) throws SQLException {
		pst.setString(1, entity.getNombre());
		pst.setString(2, entity.getCodigo());
		pst.setDate(3, new java.sql.Date(entity.getFechaVigenciaDesde().getTime()));
		pst.setDate(4, new java.sql.Date(entity.getFechaVigenciaHasta().getTime()));
		pst.setDouble(5, entity.getDescuento());		
	}

	@Override
	protected String getUpdateSQL() {
		return "nombre=?,fecha_vigencia_desde=?,fecha_vigencia_hasta=?, descuento=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Cupones entity) throws SQLException {
		pst.setString(1, entity.getNombre());
		pst.setDate(2, new java.sql.Date(entity.getFechaVigenciaDesde().getTime()));
		pst.setDate(3, new java.sql.Date(entity.getFechaVigenciaHasta().getTime()));
		pst.setDouble(4, entity.getDescuento());	
	}
}

