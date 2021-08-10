package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Socios;

public class SociosJDBCDaoImpl extends JDBCDAOBase<Socios> implements SociosDao {

	public SociosJDBCDaoImpl() {
		super("socios");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(nombre, apellido,email,fecha_alta,direccion) values(?,?,?,?)";
	}
	
	@Override
	protected void save(PreparedStatement pst, Socios entity) throws SQLException {
		pst.setString(1, entity.getNombre());
		pst.setString(2, entity.getApellido());
		pst.setString(3, entity.getEmail());
		pst.setDate(4, new java.sql.Date(entity.getFechaAlta().getTime()));
		pst.setString(5,entity.getDireccion());
	}

	@Override
	protected String getUpdateSQL() {
		return "nombre=?, apellido=?,email=?,direccion=?,paises_id=?";
	}
	
	@Override
	protected void update(PreparedStatement pst, Socios entity) throws SQLException {
		pst.setString(1, entity.getNombre());
		pst.setString(2, entity.getApellido());
		pst.setString(3, entity.getEmail());
		pst.setString(4, entity.getDireccion());
		if(entity.getPaisesId() !=null) {
			pst.setLong(5,entity.getPaisesId());
		}else {
			pst.setNull(5,Types.INTEGER);
		}
	}
	
	@Override
	public Socios getSocioByUserId(Long usersId) throws GenericException {
		String sql = "users_id =" + usersId;
		Socios socios = null;
		List<Socios> list = super.findAllBy(sql);
		if(!list.isEmpty()) {
			socios = list.get(0);
		}
		
		return socios;
	}
}

