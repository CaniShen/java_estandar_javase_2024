package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Curso;

public class CursosService {
	String cadenaConexion="jdbc:mysql://localhost:3306/formacion";
	String usuario="root";
	String password="root";

public boolean nuevoCurso(Curso curso) {
	if(existeCursoPorId)(curso.getIdCurso()!=null)  {
		return false;
	}
	try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);)  {
		String sql="insert into cursos where idCurso=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, curso.getIdCurso());
		ps.setString(2, curso.getCurso());
		ps.setInt(3,curso.getDuracion());
		ps.setDouble(4,curso.getPrecio());
		ps.setAlumno(5,curso.getAlumnos());
		ps.execute();
		return true;
	} catch (SQLException ex) {
		ex.printStackTrace();
		return false;
	}
}

private Curso existeCursoPorId(int idCurso) {
	try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);)  {
		String sql="select * from contactos where idCurso=?";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, idCurso);
		ResultSet rs=st.executeQuery();
		//debemos movernos a la primera y única fila, para poder extraer 
		//el valor de dicha fila.
			if(rs.next()) {
			return new Curso(rs.getInt("idCurso"),
					rs.getString("curso"),
					rs.getInt("duracion"),
					rs.getDouble("precio"),
					rs.getAlumno("alumnos"));
		}
			return null;
		
	}catch (SQLException ex) {
		ex.printStackTrace();
		return null;
	}
	
}
}

