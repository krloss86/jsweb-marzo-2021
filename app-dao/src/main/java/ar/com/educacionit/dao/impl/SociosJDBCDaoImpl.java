package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SociosJDBCDaoImpl extends JDBCDAOBase<Socios> implements SociosDao {

	public SociosJDBCDaoImpl() {
		super("socios");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(nombre, apellido,email,fecha_alta) values(?,?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, Socios entity) throws SQLException {
		pst.setString(1, entity.getNombre());
		pst.setString(2, entity.getApellido());
		pst.setString(3, entity.getEmail());
		pst.setDate(4, new java.sql.Date(entity.getFechaAlta().getTime()));		
	}

	@Override
	protected String getUpdateSQL() {
		return "nombre=?, apellido=?,email=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Socios entity) throws SQLException {
		pst.setString(1, entity.getNombre());
		pst.setString(2, entity.getApellido());
		pst.setString(3, entity.getEmail());
	}
}

