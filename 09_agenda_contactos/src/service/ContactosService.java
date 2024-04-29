package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Contacto;

/*1.-Nuevo Contacto
2.-Eliminar Contacto
3.-Actualizar edad
4.-Salir

1: Se piden los datos del nuevo contacto y se guarda
2: Solicita el email y borra el contacto con dicho email
3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto */
public class ContactosService {
	String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
	//si ya hay un contacto con ese email, no se añadirá y devolverá false.
	//Es decir, no se admitirán contactos con email duplicado.
public boolean nuevoContacto(Contacto contacto) {
	if(existeContactoPorEmail(contacto.getEmail())!=null) {
		return false;
	}
	try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
		String sql="insert into concatcos where email=?";
		//sustituir parámetros para valoros.
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, contacto.getNombre());
		ps.setString(2, contacto.getEmail());
		ps.setInt(3, contacto.getEdad());
		ps.execute();//No se manda otra vez la SQL.	
		return true;
	} catch (SQLException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
		return false;
	}

	
}
//devuelve el contacto eliminado.Si no se ha eliminado ninguno, de vuelve null.
public Contacto eliminarContacto(String email) {
	Contacto contacto=existeContactoPorEmail(email);
	if(contacto==null) {
		return null;
	}

	try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
		String sql="delete from contactos where email=?";
		//sustituir parámetros para valoros.
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		//ps.execute();//No se manda otra vez la SQL.	
		return contacto;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}

	
	
}

public boolean actualizarContacto(String email, int nuevaEdad ) {

	try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
		String sql="update contactos set edad=? where email=?";
		//sustituir parámetros para valoros.
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, nuevaEdad);
		ps.setString(2, email);
		//ps.execute();//No se manda otra vez la SQL.	
		return ps.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}

}

//Buscar contacto por su clave primaria
public Contacto buscarContactoPorId(int idContacto) {
	try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);)  {
		String sql="select * from contactos where idContacto=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, idContacto);
		ResultSet rs=st.executeQuery(sql);
		//debemos movernos a la primera y única fila, para poder extraer 
		//el valor de dicha fila.
		if (rs.next()) {
			return new Contacto(rs.getInt("idContacto"),
					rs.getString("nombre"),
					rs.getString("email"),
					rs.getInt("edad"));
		}
		
		return null;
	}catch (SQLException ex) {
		ex.printStackTrace();
	}
	return null;
	
	
}
//Recuperar todos los contactos
public List<Contacto> getContactos() {
	List<Contacto> contactos=new ArrayList<Contacto>();
	try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
		String sql="select * from contactos";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			contactos.add(new Contacto(rs.getInt("idContacto"),
					rs.getString("nombre"),
					rs.getString("emial"),
					rs.getInt("edad")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return contactos;
}
private Contacto existeContactoPorEmail(String email) {
	try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);)  {
		String sql="select * from contactos where email=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, email);
		ResultSet rs=st.executeQuery();
		//debemos movernos a la primera y única fila, para poder extraer 
		//el valor de dicha fila.
			if(rs.next()) {
			return new Contacto(rs.getInt("idContacto"),
					rs.getString("nombre"),
					rs.getString("email"),
					rs.getInt("edad"));
		}
			return null;
		
	}catch (SQLException ex) {
		ex.printStackTrace();
		return null;
	}
	
}

}
