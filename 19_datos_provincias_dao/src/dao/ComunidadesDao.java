package dao;

import java.util.List;

import model.Comunidad;

public interface ComunidadesDao {
	void save(Comunidad comunidad);
	void save(List<Comunidad> comunidades);
	
	//Comunidad findByComunidad(String codigo); 
	boolean existComunidad(String codigo);
	
	static ComunidadesDao of() {
		return new ComunidadesDaoImpl();
	}

}
