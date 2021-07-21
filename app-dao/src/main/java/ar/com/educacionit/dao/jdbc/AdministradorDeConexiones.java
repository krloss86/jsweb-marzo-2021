package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		
		String url = "jdbc:postgresql://ec2-35-174-122-153.compute-1.amazonaws.com/dev4u03tup2l15";

		String user ="fwbhwfmiaiacla";
		String password = "1c5bc164fc9dd6fac878c75684f99074716202336e59c06393900c1c56ef8ed5";
		
		String driverName = "org.postgresql.Driver";
		
		//crear una instancia para dicho driver!
		try {
			Class.forName(driverName);
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new GenericException("No se ha podido obtener una conexion", e);
		}
	}
	
	public static void main(String[] args) {
		try(Connection c = obtenerConexion()) {
			System.out.println("conexion obtenida");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("conexion cerrada");
		}
		
	} 
	
}
