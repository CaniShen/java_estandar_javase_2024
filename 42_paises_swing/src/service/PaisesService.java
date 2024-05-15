package service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Pais;

public interface PaisesService {

	//-Lista de continentes
	List<String> getContinentes();

	//-Lista de paises a partir del continente
	List<Pais> getPaisesFiltradosPor(String continente);

	//-Pais más poblado
	Optional<Pais> getPaisMasPoblado();

	//-Tabla con paises agurpados por continente
	Map<String, List<Pais>> getTablaPaisContinente();

	//-Pais a partir de su capital */
	String getPaisFiltradoPor(String capital);

}