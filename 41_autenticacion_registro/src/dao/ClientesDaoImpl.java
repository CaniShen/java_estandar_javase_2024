package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cliente;

public class ClientesDaoImpl implements ClientesDao {

	@Override
	public Cliente findByUsuario(String usuario) {
		try(Connection con=LocatorConnection.getConnection()) {
			String sql="select from clientes where usuario=?";
			//sustituir parámetros para valoros.
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, usuario);
			ResultSet rs=st.executeQuery();
			//debemos movernos a la primera y única fila, para poder extraer
			//el valor de dicha fila
			if(rs.next()) {
				return new Cliente(rs.getInt("idContacto"),
							rs.getString("usuario"),
							rs.getString("password"),
							rs.getString("email"),
							rs.getInt("telefono"));
			}
		
		
			return null;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}


				
		}

	@Override
	public void save(Cliente cliente) {
		try(Connection con=LocatorConnection.getConnection()){		
			String sql="insert into clientes(usuario, password, email,telefono) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cliente.getUsuario());
			ps.setString(2, cliente.getPassword());
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getTelefono());
			ps.execute();		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	} 
	}


