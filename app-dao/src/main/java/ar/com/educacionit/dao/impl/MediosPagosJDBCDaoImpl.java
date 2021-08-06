package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.MediosPagosDao;
import ar.com.educacionit.domain.MediosPagos;

public class MediosPagosJDBCDaoImpl extends JDBCDAOBase<MediosPagos> implements MediosPagosDao {

	public MediosPagosJDBCDaoImpl() {
		super("medios_pagos");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(descripcion, descripcion_corta, codigo, habilitada) values(?,?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, MediosPagos entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setString(3, entity.getCodigo());
		pst.setLong(4, entity.getHabilitada());
	}

	@Override
	protected String getUpdateSQL() {
		return "descripcion=?, descripcion_corta=?,habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, MediosPagos entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getHabilitada());
	}
}

