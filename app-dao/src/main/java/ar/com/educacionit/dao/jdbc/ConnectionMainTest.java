package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public class ConnectionMainTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Instanciando conexion");
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		System.out.println("Creando producto");
		Producto p = new Producto("TEST", 1000D, "TEST2", 1l);		
		createProducto(connection, p);		
		System.out.println("-------------------------------------");
	
		System.out.println("Consultando registros en la db");		
		Collection<Producto> productos = selectAll(connection);
		
		//recorrer
		Long id = null;
		for(Producto producto : productos) {
			System.out.println(producto);
			id = producto.getId();
		}
		System.out.println("-------------------------------------");
		Producto producto = selectById(connection, id);
		System.out.println("Producto con id="+id +" - "+ producto);
		
		System.out.println("-------------------------------------");
		producto = selectByCodigo(connection, producto.getCodigo());
		System.out.println("Producto con codigo="+id +" - "+ producto);
		
		System.out.println("-------------------------------------");
		producto.setPrecio(producto.getPrecio() * 1.1f);
		producto = updateProducto(connection, producto.getId(), producto);
		System.out.println("Se ha actualizado el producto id:" + producto.getId());
		
		productos = selectAll(connection);		
		for(Producto productoAux : productos) {
			System.out.println(productoAux);
		}
		
		System.out.println("-------------------------------------");
		producto =  deleteProducto(connection, id);
		System.out.println("Se ha eliminado el producto id:" + producto.getId());
		
		connection.close();

		System.out.println("Test ok");
	}

	public static Producto createProducto(Connection connection, Producto producto) throws Exception {
		
		String sql = "INSERT INTO productos (titulo, precio,codigo, id_tipo_producto) "
				+ "VALUES ('"+producto.getTitulo()+"', '"+producto.getPrecio()+"','"+producto.getCodigo()+"', '"+producto.getTipoProducto()+"')";
		
		PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		if(resultSet.next()) {
			Long pk = resultSet.getLong(1);
			producto.setId(pk);
		}else {
			throw new Exception("No se ha podido obtener el id generado");
		}
		
		statement.close();
		
		return producto;		
	}
	
	public static Collection<Producto> selectAll(Connection connection) throws Exception {
		
		String sqlSelect = "select * from productos";
		
		Statement statement =  connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Collection<Producto> productos = new ArrayList<Producto>(); 
				
		//if(resultSet.next()) { //encontró registros?
		while(resultSet.next()) {
			Producto producto = productoFromResultSet(resultSet);
			
			productos.add(producto);
		}
		
		statement.close();
		
		return productos;
	}
	
	public static Producto selectById(Connection connection, Long idProducto) throws Exception {
		
		String sqlSelect = "SELECT * FROM productos WHERE id = " + idProducto;
		
		Statement statement =  connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Producto producto = null; 
				
		if(resultSet.next()) { //encontró registros?
			producto = productoFromResultSet(resultSet);
		}
		
		statement.close();
		
		return producto;
	}
	
	public static Producto selectByCodigo(Connection connection, String codigoProducto) throws Exception {
		
		String sqlSelect = "SELECT * FROM productos WHERE codigo = '" + codigoProducto+"'";
		
		Statement statement =  connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		Producto producto = null; 
				
		if(resultSet.next()) { //encontró registros?
			producto = productoFromResultSet(resultSet);
		}
		
		statement.close();
		
		return producto;
	}
	
	public static Producto updateProducto(Connection connection,Long idProducto, Producto producto) throws Exception {

		Producto productoBuscador = selectById(connection, idProducto);
		
		if(productoBuscador == null) {
			throw new Exception("No existe producto id:" + idProducto);
		}
		
		String sqlSelect = "UPDATE productos "
				+ " set titulo='"+producto.getTitulo()+"',"
				+ " precio='"+producto.getPrecio()+ "',"
				+ " id_tipo_producto='"+producto.getTipoProducto()+ "'"
				+ " WHERE id='" + idProducto+"'";
		
		Statement statement =  connection.createStatement();
		
		int updated = statement.executeUpdate(sqlSelect);
						
		statement.close();
		
		if(updated !=1) { //encontró registros?
			throw new Exception("No se ha podido modificar los datos del producto id:"+ idProducto);
		}
		
		producto = selectById(connection, idProducto);
		
		return producto;

	}
	
	public static Producto deleteProducto(Connection connection, Long id) throws Exception {
		
		Producto productoBuscado = selectById(connection, id);
		
		if(productoBuscado == null) {
			throw new Exception("No existe productos id:" + id);
		}
		
		String sql = "DELETE FROM PRODUCTOS WHERE ID = " + id;
		
		Statement statement = connection.createStatement();
		
		int deleted = statement.executeUpdate(sql);
		
		statement.close();
		
		if(deleted !=1) {
			throw new Exception("No se ha podido eliminar el producto id:" + id);
		}
		
		return productoBuscado;
	}
	
	/**
	 * Contruye un producto desde el resultset
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private static Producto productoFromResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1);//ID
		String titulo = resultSet.getString(2);
		Double precio = resultSet.getDouble(3);
		String codigo = resultSet.getString(4);
		Long tipoProducto = resultSet.getLong(5);
		
		producto = new Producto(id, titulo, precio, codigo, tipoProducto);
		return producto;
	}
	
}
