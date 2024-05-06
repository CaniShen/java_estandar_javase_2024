package dao;

import java.util.List;

import model.Comunidad;

public interface ComunidadesDao {
	void save(Comunidad comunidad);
	Comunidad findByComunidad(String nombreComunidad); 
	
	static ComunidadesDao of() {
		return new ComunidadesDaoImpl();
	}

}
