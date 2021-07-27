package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.PaisesDao;
import ar.com.educacionit.domain.Paises;

public class PaisesJDBCDaoImpl extends JDBCDAOBase<Paises> implements PaisesDao {

	public PaisesJDBCDaoImpl() {
		super("paises");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(descripcion, descripcion_corta,habilitada) values(?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, Paises entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getHabilitada());
	}

	@Override
	protected String getUpdateSQL() {
		return "descripcion=?, descripcion_corta=?,habilitada=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Paises entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getDescripcionCorta());
		pst.setLong(3, entity.getHabilitada());
	}
}

