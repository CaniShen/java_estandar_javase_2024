package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {

	@Override
	public List<Cliente> findByCuenta(int idCuenta) {
		List<Cliente> lista=new ArrayList<Cliente>();
		try(Connection con=LocatorConnection.getConnection();) {
			String sql="select c.* from clientes c, titulares t where t.idCuenta = ? and t.idCliente = c.dni ";
			PreparedStatement ps = con.prepareStatement(sql); //ejecutar la consulta de SQL
			ps.setInt(1, idCuenta);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				lista.add(new Cliente(rs.getInt("dni"),
						rs.getString("nombre"),
						rs.getString("direccion"),
						rs.getString("telefono")));
				
			}
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lista;
	}

}
