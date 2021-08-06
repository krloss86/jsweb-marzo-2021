package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.OrdenesDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.Ordenes;

public class OrdenesJDBCDaoImpl extends JDBCDAOBase<Ordenes> implements OrdenesDao {

	public OrdenesJDBCDaoImpl() {
		super("ordenes");
	}

	@Override
	protected void update(PreparedStatement pst, Ordenes entity) throws SQLException {
		pst.setLong(1,entity.getEstadosOrdenesId());
		pst.setDouble(2, entity.getMontoTotal());
		if(entity.getCuponesId() != null) {
			pst.setLong(3,entity.getCuponesId());
		}else {
			pst.setNull(3, Types.INTEGER);
		}
	}

	@Override
	protected String getUpdateSQL() {		
		return "estados_ordenes_id=?, monto_total=?, cupones_id=?";
	}

	@Override
	protected void save(PreparedStatement pst, Ordenes entity) throws SQLException {
		pst.setDate(1, new java.sql.Date(entity.getFechaCreacion().getTime()));
		//convierto java.util.data a java.sql.Date
		pst.setLong(2, entity.getSociosId());
		pst.setLong(3,entity.getEstadosOrdenesId());
		pst.setDouble(4, entity.getMontoTotal());
		if(entity.getCuponesId() != null) {
			pst.setLong(5,entity.getCuponesId());
		}else {
			pst.setNull(5, Types.INTEGER);
		}
	}

	@Override
	protected String getSaveSQL() {
		return "(fecha_creacion,socios_id,estados_ordenes_id,monto_total,cupones_id) values (?,?,?,?,?)";
	}
	
	/*
	@Override
	public Long save(List<Long> itemsIds, Double montoTotal, Long sociosId) throws GenericException{
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion()) {
			
			con.setAutoCommit(false);

			String sql = "INSERT INTO " + this.tabla + this.getSaveSQL();
			
			try (PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

				Ordenes entity = new Ordenes();
				entity.setEstadosOrdenesId(1L);//creada
				entity.setFechaCreacion(new Date());
				entity.setMontoTotal(null);
				entity.setSociosId(sociosId);
				
				this.save(pst, entity);
				
				pst.execute();

				try (ResultSet resultSet = pst.getGeneratedKeys()) {

					if (resultSet.next()) {

						Long lastGeneratedId = resultSet.getLong(1);

						entity.setId(lastGeneratedId);
					}
				}
				
				//ahora grabo los items ordenes
				sql = "INSERT ORDENES_ITEMS ";
			}
		} catch (SQLException e2) {
			if (e2 instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido crear el producto, integridad violada", e2);
			}
			throw new GenericException("No se ha podido crear el producto", e2);
		}
	}
	*/
}
