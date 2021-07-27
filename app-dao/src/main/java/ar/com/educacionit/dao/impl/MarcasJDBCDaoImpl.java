package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.domain.Marcas;

public class MarcasJDBCDaoImpl extends JDBCDAOBase<Marcas> implements MarcasDao {

	public MarcasJDBCDaoImpl() {
		super("marcas");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(descripcion,codigo,habilitada) VALUES (?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, Marcas entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getCodigo());
		pst.setLong(3, entity.getHabilitada());
	}

	@Override
	protected String getUpdateSQL() {
		return "descripcion=?, habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Marcas entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setLong(2, entity.getHabilitada());
	}
}

