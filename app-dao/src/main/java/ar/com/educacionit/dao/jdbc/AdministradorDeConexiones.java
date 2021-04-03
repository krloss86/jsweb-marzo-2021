package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		
		String url = "jdbc:mysql://127.0.0.1/jsweb-marzo?serverTimeZone=UTC&userSSL=false";

		String user ="root";
		String password = "root";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		//crear una instancia para dicho driver!
		try {
			Class.forName(driverName);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericException("No se ha podido obtener una conexion", e);
		}
	}
}
