package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Alumno;


public class AlumnosService {
	String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";
 public boolean nuevoAlumno(Alumno alumno) {
	 if(existeAlumnoPorDni(alumno.getDni())!=null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion, usuario, password);) {
			String sql="insert into alumnos where dni=?";
			//sustituir parámetros para valoros.
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, alumno.getDni());
			ps.setString(2, alumno.getNombre());
			ps.setInt(3, alumno.getEdad());
			ps.setDouble(4, alumno.getNota());
			ps.execute();//No se manda otra vez la SQL.	
			return true;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return false;
		}

 }
private Alumno existeAlumnoPorDni(String dni) {
	try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);)  {
		String sql="select * from alumnos where dni=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1, dni);
		ResultSet rs=st.executeQuery();
		//debemos movernos a la primera y única fila, para poder extraer 
		//el valor de dicha fila.
			if(rs.next()) {
			return new Alumno(rs.getString("dni"),
					rs.getString("nombre"),
					rs.getInt("edad"),
					rs.getDouble("nota"),
					rs.getInt("idCurso"));
		}
			return null;
		
	}catch (SQLException ex) {
		ex.printStackTrace();
		return null;
	}
}
}
