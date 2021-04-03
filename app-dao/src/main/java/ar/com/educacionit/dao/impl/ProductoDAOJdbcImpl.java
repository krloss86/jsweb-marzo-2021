package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.Producto;

public class ProductoDAOJdbcImpl implements ProductoDAO {

	public Producto create(Producto producto) throws DuplicatedException, GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion(); 
		
		String sql = "INSERT INTO productos (titulo, precio,codigo, id_tipo_producto) "
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"','"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"')";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			statement.execute();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			
			if(resultSet.next()) {
				Long pk = resultSet.getLong(1);
				producto.setId(pk);
			}else {
				throw new GenericException("No se ha podido obtener la PK",null);
			}
			
			statement.close();
		}catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("Clave duplicada, no se ha registrado el producto", e);
			}
			throw new GenericException("No se ha podido crear el producto", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
		
		return producto;		
	}
	
	public Collection<Producto> findAll() throws GenericException {
		
		Collection<Producto> productos = new ArrayList<Producto>();
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "select * from productos";
		
		try {
			Statement statement =  connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			
					
			//if(resultSet.next()) { //encontr� registros?
			while(resultSet.next()) {
				Producto producto = productoFromResultSet(resultSet);
				
				productos.add(producto);
			}
			
			statement.close();
			
			return productos;
		}catch (SQLException e) {
			throw new GenericException("No se ha podido crear el producto", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e1);
			}
		}
		
	}
	
	public Producto getById(Long idProducto) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE id = " + idProducto;
		
		try {
			Statement statement =  connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			
			Producto producto = null; 
					
			if(resultSet.next()) { //encontr� registros?
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
			
			return producto;
		}catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e1);
			}
		}
	}
	
	public Producto getByCodigo(String codigoProducto) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM productos WHERE codigo = '" + codigoProducto+"'";
		
		try {
			Statement statement =  connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			
			Producto producto = null; 
					
			if(resultSet.next()) { //encontr� registros?
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();
			
			return producto;
			
		}catch (SQLException e) {
			throw new GenericException("No se ha podido obtener el producto", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e1);
			}
		}
	}
	
	public Producto update(Producto producto) throws GenericException {

		Producto productoBuscador = this.getById(producto.getId());
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(productoBuscador == null) {
			throw new GenericException("No existe producto id:" + producto.getId(), null);
		}
		
		String sqlSelect = "UPDATE productos "
				+ " set titulo='"+producto.getTitulo()+"',"
				+ " precio='"+producto.getPrecio()+ "',"
				+ " id_tipo_producto='"+producto.getTipoProducto()+ "'"
				+ " WHERE id='" + producto.getId()+"'";
		
		try {
			Statement statement =  connection.createStatement();
			
			int updated = statement.executeUpdate(sqlSelect);
							
			statement.close();
			
			if(updated !=1) { //encontr� registros?
				throw new Exception("No se ha podido modificar los datos del producto id:"+ producto.getId());
			}
			
			producto = this.getById(producto.getId());
			
			return producto;
		}catch (Exception e) {
			throw new GenericException("No se ha podido actualizar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
	}
	
	public Producto deleteById(Long id) throws GenericException {
		
		Producto producto = this.getById(id);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(producto == null) {
			throw new GenericException("No existe producto id:" + id, null);
		}		
		
		String sql = "DELETE FROM PRODUCTOS WHERE ID = " + id;
		
		try {
			Statement statement = connection.createStatement();
			
			int deleted = statement.executeUpdate(sql);
			
			statement.close();
			
			if(deleted !=1) {
				throw new Exception("No se ha podido eliminar el producto id:" + id);
			}
		}catch (Exception e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
		
		return producto;
	}
	
	public Producto deleteByCodigo(String codigo) throws GenericException {
		
		Producto producto = this.getByCodigo(codigo);
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(producto == null) {
			throw new GenericException("No existe producto id:" + codigo, null);
		}		
		
		String sql = "DELETE FROM PRODUCTOS WHERE codigo = " + codigo;
		
		try {
			Statement statement = connection.createStatement();
			
			int deleted = statement.executeUpdate(sql);
			
			statement.close();
			
			if(deleted !=1) {
				throw new Exception("No se ha podido eliminar el producto id:" + codigo);
			}
		}catch (Exception e) {
			throw new GenericException("No se ha podido eliminar el producto", e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verique en la base de datos",e);
			}
		}
		
		return producto;
	}
	
	/**
	 * Contruye un producto desde el resultset
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private Producto productoFromResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1);//ID
		String titulo = resultSet.getString(2);
		Float precio = resultSet.getFloat(3);
		String codigo = resultSet.getString(4);
		Long tipoProducto = resultSet.getLong(5);
		
		producto = new Producto(id, titulo, precio, codigo, tipoProducto);
		return producto;
	}

	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {
		return this.findAll();
	}

}