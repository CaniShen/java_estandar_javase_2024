package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contacto;

/*1.-Nuevo Contacto
2.-Eliminar Contacto
3.-Actualizar edad
4.-Salir

1: Se piden los datos del nuevo contacto y se guarda
2: Solicita el email y borra el contacto con dicho email
3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto */
public class ContactoService {
	String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
public void nuevoContacto(Contacto contacto) {

	String name="nombre";
	String email="email@gmail.com";
	int edad=20;
	try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
		String sql="insert into concatcos(nombre,email,edad) value(?,?,?)";
		//sustituir parámetros para valoros.
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, contacto.getNombre());
		ps.setString(2, contacto.getEmail());
		ps.setInt(3, contacto.getEdad());
		ps.execute();//No se manda otra vez la SQL.	
		
	} catch (SQLException ex) {
		// TODO Auto-generated catch block
		ex.printStackTrace();
	}

	
}
public boolean eliminarContacto(String email) {

	try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
		String sql="delete from contactos where email=?";
		//sustituir parámetros para valoros.
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		//ps.execute();//No se manda otra vez la SQL.	
		return ps.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
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
}
