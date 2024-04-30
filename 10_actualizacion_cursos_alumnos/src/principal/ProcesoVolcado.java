package principal;

import java.util.List;

import model.Curso;
import service.AlumnosService;
import service.CursosJsonService;
import service.CursosService;

public class ProcesoVolcado {

	public static void main(String[] args) {
		var alumnosService=new AlumnosService();
		var cursosService=new CursosService();
		var cursosJsonService=new CursosJsonService();
		//Lista de cursos del fichero
		List<Curso> cursos=cursosJsonService.cursosAlumnos();
		//por cada curso,comprobamos si está. Si no está, lo añadimos
		//y también sus alumnos. Si el curso está, no lo añadimos y reco-
		//rremos sus alumnos, para ver si hay alguno nuevo que añadir.
		
		cursos.forEach(c->{
			if(cursosService.existeCursoPorId(c.getIdCurso())==null) {
				cursosService.nuevoCurso(c);
				c.getAlumnos().forEach(a->{
					//le asignamos al alumno el idCurso al que pertenece
					a.setIdCurso(c.getIdCurso());
					alumnosService.nuevoAlumno(a);
				});
			}else {
				c.getAlumnos().forEach(a->{
					if(alumnosService.existeAlumnoPorDni(a.getDni())==null) {
						//le asignamos al alumno el idCurso al que pertenece
						a.setIdCurso(c.getIdCurso());
						alumnosService.nuevoAlumno(a);
					}
				});
			}
		});
	}

}
