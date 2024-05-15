package service;

import java.util.List;

import model.Municipio;
import model.Provincia;

public interface DatosProvinciasService {

	List<String> comunidades();

	List<Provincia> provinciasFiltradosPor(String comunidad);

	List<Municipio> municipios();

	List<Municipio> municipiosComunidad(String comunidad);
	
	List<Municipio> municipiosFiltradosPor(String provincia);

}