package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.DireccionesOrdenesDao;
import ar.com.educacionit.domain.DireccionesOrdenes;

public class DireccionesOrdenesJDBCDaoImpl extends JDBCDAOBase<DireccionesOrdenes> implements DireccionesOrdenesDao {

	public DireccionesOrdenesJDBCDaoImpl() {
		super("direcciones_ordenes");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(ordenes_id, paises_id, direccion_envio) values(?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, DireccionesOrdenes entity) throws SQLException {
		pst.setLong(1, entity.getOrdenesId());
		pst.setLong(2, entity.getPaisesId());
		pst.setString(3, entity.getDireccionEnvio());
	}

	@Override
	protected String getUpdateSQL() {
		return "";//"descripcion=?, descripcion_corta=?,habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, DireccionesOrdenes entity) throws SQLException {
		/*pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getHabilitada());*/
	}
}

