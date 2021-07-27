package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.CategoriasDao;
import ar.com.educacionit.domain.Categoria;

public class CategoriaJDBCDaoImpl2 extends JDBCDAOBase<Categoria> implements CategoriasDao {

	public CategoriaJDBCDaoImpl2() {
		super("categorias");
	}
	
	protected void save(PreparedStatement pst, Categoria entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setString(2, entity.getCodigo());
		pst.setLong(3, entity.getHabilitada());
	}

	protected String getSaveSQL() {
		return "(descripcion,codigo,habilitada) VALUES (?,?,?)";
	}

	@Override
	protected void update(PreparedStatement pst, Categoria entity) throws SQLException {
		pst.setString(1, entity.getDescripcion());
		pst.setLong(2, entity.getHabilitada());
	}

	@Override
	protected String getUpdateSQL() {
		return "descripcion=?, habilitada=?";
	}
}
