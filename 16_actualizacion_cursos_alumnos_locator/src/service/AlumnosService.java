package service;

import model.Alumno;

public interface AlumnosService {

	boolean nuevoAlumno(Alumno alumno);

	Alumno existeAlumnoPorDni(String dni);

	
	static AlumnosService of() {
		return new AlumnosServiceImpl();
	}
}