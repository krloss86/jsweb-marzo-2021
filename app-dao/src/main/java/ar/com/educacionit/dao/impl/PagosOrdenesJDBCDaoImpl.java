package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.PagosOrdenesDao;
import ar.com.educacionit.domain.PagosOrdenes;

public class PagosOrdenesJDBCDaoImpl extends JDBCDAOBase<PagosOrdenes> implements PagosOrdenesDao {

	public PagosOrdenesJDBCDaoImpl() {
		super("pagos_ordenes");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(ordenes_id, medios_pagos_id, fecha_pago, monto) values(?,?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, PagosOrdenes entity) throws SQLException {
		pst.setLong(1, entity.getOrdenesId());
		pst.setLong(2, entity.getMediosPagosId());
		pst.setDate(3, new java.sql.Date(entity.getFechaPago().getTime()));
		pst.setDouble(4, entity.getMonto());
	}

	@Override
	protected String getUpdateSQL() {
		return "";//"descripcion=?, descripcion_corta=?,habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, PagosOrdenes entity) throws SQLException {
		/*pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getHabilitada());*/
	}
}

