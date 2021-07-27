package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.ArticulosDao;
import ar.com.educacionit.domain.Articulos;

public class ArticulosJDBCDaoImpl extends JDBCDAOBase<Articulos> implements ArticulosDao {

	public ArticulosJDBCDaoImpl() {
		super("articulos");
	}

	@Override
	protected void update(PreparedStatement pst, Articulos entity) throws SQLException {
		pst.setString(1, entity.getTitulo());
		//convierto java.util.data a java.sql.Date
		pst.setFloat(2, entity.getPrecio());
		pst.setLong(3, entity.getStock());
		pst.setLong(4, entity.getMarcasId());
		pst.setLong(5, entity.getCategoriasId());	
	}

	@Override
	protected String getUpdateSQL() {		
		return "titulo=?, precio=?, stock=?, marcas_id=?,categorias_id=?";
	}

	@Override
	protected void save(PreparedStatement pst, Articulos entity) throws SQLException {
		pst.setString(1, entity.getTitulo());
		//convierto java.util.data a java.sql.Date
		pst.setDate(2, new java.sql.Date(entity.getFechaCreacion().getTime()));
		pst.setString(3, entity.getCodigo());
		pst.setFloat(4,entity.getPrecio());
		pst.setLong(5, entity.getStock());
		pst.setLong(6,entity.getMarcasId());
		pst.setLong(7, entity.getCategoriasId());		
	}

	@Override
	protected String getSaveSQL() {
		return "(titulo,fecha_creacion,codigo,precio,stock,marcas_id,categorias_id) values (?,?,?,?,?,?,?)";
	}

}
