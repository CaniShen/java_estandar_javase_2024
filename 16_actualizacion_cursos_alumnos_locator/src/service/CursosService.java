package service;

import model.Curso;

public interface CursosService {

	Curso existeCursoPorId(int idCurso);

	boolean altaCurso(Curso curso);

}