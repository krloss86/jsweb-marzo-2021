package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.CategoriasDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.Categoria;

public class CategoriasDBCDaoImpl implements CategoriasDao {

	@Override
	public List<Categoria> findAll() throws GenericException {

		List<Categoria> list = new ArrayList<>();

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "SELECT * FROM categorias";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				try (ResultSet res = pst.executeQuery()) {

					list = DTOUtils.populateDTOs(Categoria.class, res);
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se ha podido consultar la lista", e);
		}

		return list;
	}

	@Override
	public Categoria getOne(Long id) throws GenericException {
		
		Categoria entity = null;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "SELECT * FROM categorias where id=?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setLong(1, id);
				
				try (ResultSet res = pst.executeQuery()) {

					if(res.next()) {
						entity = new Categoria();
						entity.setId(res.getLong(1));
						entity.setDescripcion(res.getString(2));
						entity.setHabilitada(res.getLong(3));
					}
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se ha podido consultar la lista", e);
		}
		
		return entity;
	}

	@Override
	public void delete(Long id) throws GenericException {
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "DELETE FROM categorias WHERE id =?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				
				pst.setLong(1, id);
				
				pst.executeUpdate();
			}
		} catch (SQLException e1) {
			throw new GenericException("No se ha podido eliminar el producto", e1);
		}
	}

	@Override
	public void save(Categoria entity) throws DuplicatedException, GenericException {

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "INSERT INTO categorias (descripcion,habilitado) VALUES (?,?)";

			try (PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				pst.setString(1, entity.getDescripcion());

				pst.setLong(2, entity.getHabilitada());

				pst.execute();

				try (ResultSet resultSet = pst.getGeneratedKeys()) {

					if (resultSet.next()) {

						Long lastGeneratedId = resultSet.getLong(1);

						entity.setId(lastGeneratedId);
					}
				}
			}
		} catch (SQLException e2) {
			if (e2 instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido crear el producto, producto duplicado", e2);
			}
			throw new GenericException("No se ha podido crear el producto", e2);
		}
	}
	
	@Override
	public void update(Categoria entity) throws DuplicatedException, GenericException {
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "UPDTE categorias set descripcion=?, habilitado=? where id=?";

			try (PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				pst.setString(1, entity.getDescripcion());

				pst.setLong(2, entity.getHabilitada());

				pst.setLong(3, entity.getId());
				
				pst.execute();				
			}
		} catch (SQLException e2) {
			if (e2 instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido crear el producto, producto duplicado", e2);
			}
			throw new GenericException("No se ha podido crear el producto", e2);
		}		
	}
}
