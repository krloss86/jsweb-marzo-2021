package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.User;

public class UserDaoImpl implements UserDao {

	public User getByUserName(String user) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "SELECT * FROM users WHERE upper(username) = '"+user.toUpperCase()+"'";
		
		try {
			PreparedStatement statement =  connection.prepareStatement(sqlSelect);
			
			// statement.setString(1, codigoProducto);
			
			ResultSet resultSet = statement.executeQuery();
			
			User usuario = null; 
					
			if(resultSet.next()) { //encontró registros?
				Long id = resultSet.getLong(1);
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				usuario = new User(id, username, password);
			}
			
			statement.close();
			
			return usuario;
			
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
}
