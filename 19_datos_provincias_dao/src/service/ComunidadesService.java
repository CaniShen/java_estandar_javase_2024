package service;

import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;

public interface ComunidadesService {
	
	//salva la lista de comunidades, evitandoguardar por segunda vez.
	//comunidades que ya estén en la base de datos.devuelve el total 
	//de comunidades guardadas.
	int saveComunidades(List<Comunidad> comunidades);
	//salva la lista de comunidades, evitandoguardar por segunda vez.
	//provincias que ya estén en la base de datos.devuelve el total 
	//de provincias guardadas.
	void saveProvincias(List<Provincia> provincias);
	//salva la lista de municipios, evitandoguardar por segunda vez.
	//municipios que ya estén en la base de datos.devuelve el total 
	//de municipios guardadas.
	void saveMunicipios(List<Municipio> municipios);

}