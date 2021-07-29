package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
import ar.com.educacionit.domain.Entity;

public abstract class JDBCDAOBase<T extends Entity> implements GenericDao<T>{

	protected Class<T> clazz;
	protected String tabla;
	
	public JDBCDAOBase(String tabla) {
		//obtiene la clase parametrizada
		//ej: si extend JDBCDAOBase<Categoria> la clase sera Categoria
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.tabla = tabla;
	}

	public List<T> findAll() throws GenericException {
		
		List<T> list = new ArrayList<>();

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "SELECT * FROM " + this.tabla;

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				try (ResultSet res = pst.executeQuery()) {
					list = (List<T>)DTOUtils.populateDTOs(this.clazz, res);
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se ha podido consultar la lista", e);
		}

		return list;
	}
	
	public List<T> findAllBy(String sqlWhere) throws GenericException {
		
		List<T> list = new ArrayList<>();

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "SELECT * FROM " + this.tabla + " where " + sqlWhere;

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				try (ResultSet res = pst.executeQuery()) {
					list = (List<T>)DTOUtils.populateDTOs(this.clazz, res);
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se ha podido consultar la lista", e);
		}

		return list;
	}

	public T getOne(Long id) throws GenericException {
		
		T entity = null;
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "SELECT * FROM "+this.tabla+" where id=?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setLong(1, id);
				
				try (ResultSet res = pst.executeQuery()) {
					
					List<T> list = (List<T>)DTOUtils.populateDTOs(this.clazz, res);
					
					if(!list.isEmpty()) {
						entity = list.get(0);
					}
				}
			}
		} catch (SQLException e) {
			throw new GenericException("No se ha podido consultar la lista", e);
		}
		
		return entity;
	}

	
	public void delete(Long id) throws GenericException {
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "DELETE FROM " + this.tabla +" WHERE id =?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				
				pst.setLong(1, id);
				
				pst.executeUpdate();
			}
		} catch (SQLException e1) {
			throw new GenericException("No se ha podido eliminar el " + this.clazz, e1);
		}
	}

	
	public void save(T entity) throws DuplicatedException, GenericException {

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "INSERT INTO " + this.tabla + this.getSaveSQL();
			
			try (PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				this.save(pst, entity);
				
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
				throw new DuplicatedException("No se ha podido crear el producto, integridad violada", e2);
			}
			throw new GenericException("No se ha podido crear el producto", e2);
		}
	}
	
	public void update(T entity) throws DuplicatedException, GenericException {

		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {

			String sql = "UPDATE "+ this.tabla + " set "+ this.getUpdateSQL() +" where id=?" ;
			long lastWildcardidPosition = sql.chars().filter(c-> c=='?').count();
			
			try (PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				this.update(pst, entity);
				
				pst.setLong((int)lastWildcardidPosition, (Long)entity.getId());
				
				pst.execute();				
			}
		} catch (SQLException e2) {
			if (e2 instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido crear el producto, producto duplicado", e2);
			}
			throw new GenericException("No se ha podido crear el producto", e2);
		}
	}

	protected abstract void update(PreparedStatement pst, T entity) throws SQLException;
	protected abstract String getUpdateSQL();

	protected abstract void save(PreparedStatement pst, T entity) throws SQLException;
	protected abstract String getSaveSQL();
}
