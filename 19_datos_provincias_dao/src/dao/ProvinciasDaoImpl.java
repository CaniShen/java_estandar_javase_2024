package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import locator.LocatorConnection;
import model.Provincia;

public class ProvinciasDaoImpl implements ProvinciasDao {

	@Override
	/*public void save(Provincia provincia) {
		try(Connection con=LocatorConnection.getConnection()) {
			String sql="insert into provincias(codigo,nombre,comunidad,codComunidad)"
					+ " value(?,?,?,?)"; 
			PreparedStatement ps=con.prepareStatement(sql);
			 
				ps.setString(1, provincia.getCodigo());
				ps.setString(2, provincia.getNombre());
				ps.setString(3, provincia.getComunidad());
				ps.setString(4, provincia.getCodComunidad());
				ps.execute();//ejecutarla sentencia SQL.
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}*/
	public void saveProvincias(List<Provincia> provincias) {
		try(Connection con=LocatorConnection.getConnection();) {
			String sql="insert into provincias(codigo,nombre,codComunidad)"
					+ " value(?,?,?)"; 
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancelamos autocommit
			 for(Provincia p:provincias) {
				ps.setString(1, p.getCodigo());
				ps.setString(2, p.getNombre());
				ps.setString(3, p.getCodComunidad());
				ps.execute();//ejecutarla sentencia SQL.	
		}
		con.commit();
	}
	catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	/*public Provincia findByName(String nombreProvincia) {
		try(Connection con=LocatorConnection.getConnection()) {
			String sql="select * from provincias where nombre=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, nombreProvincia);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Provincia(rs.getString("codigo"),
						rs.getString("nombre"),
						rs.getString("comunidad"),
						rs.getString("codComunidad"));
						
						
			}
			return null;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
			
		}
		return null;
	}*/

	public List<String> findCodigos() {
		List<String> codigos=new ArrayList<String>();
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select codigo from provincias";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				codigos.add(rs.getString(1));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return codigos;
	}


}
