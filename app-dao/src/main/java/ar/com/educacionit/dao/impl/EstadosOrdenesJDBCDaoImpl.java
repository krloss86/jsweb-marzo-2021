package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.EstadosOrdenesDao;
import ar.com.educacionit.domain.EstadosOrdenes;

public class EstadosOrdenesJDBCDaoImpl extends JDBCDAOBase<EstadosOrdenes> implements EstadosOrdenesDao {

	public EstadosOrdenesJDBCDaoImpl() {
		super("estados_ordenes");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(descripcion,descripcion_corta,estado_final) values(?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, EstadosOrdenes entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getEstadoFinal());
	}

	@Override
	protected String getUpdateSQL() {
		return "descripcion=?,descripcion_corta=?,estado_final=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, EstadosOrdenes entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getEstadoFinal());
	}
}

