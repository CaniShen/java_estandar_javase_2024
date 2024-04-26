package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


import model.Pais;

/*Implementar lógica de negocio de una aplicación que proporcione información
sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes

-Lista de continentes
-Lista de paises a partir del continente
-Pais más poblado
-Tabla con paises agurpados por continente
-Pais a partir de su capital */
public class PaisesService {
	String ruta="paises.json";
	private  Stream<Pais> getPais() {
		Gson gson=new Gson();
		try {
			return Arrays.stream(gson.fromJson(new FileReader("paises.json"), Pais[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {

			e.printStackTrace();
			return Stream.empty();
	}
}
	//-Lista de continentes
	public List<String> listaContinente() {
		return getPais() //Stream<Pais>
				.map(c->c.getContinente()) //Stream<String>
				.distinct()
				.toList();
				
	}
	//-Lista de paises a partir del continente
	public List<Pais> listaPaises(String continente) {
		return getPais() //Stream<Pais>
				.filter(p->p.getContinente().equalsIgnoreCase(continente))//Stream<Pais>?????????????
				.toList();
	}
	//-Pais más poblado
	public  Optional<Pais> paisMasPoblado() {
		return getPais()//Stream<Pais>
				.max(Comparator.comparingLong(p->p.getHabitantes()));
	}
	//-Tabla con paises agurpados por continente
	public  Map<String, List<Pais>> getTablaPaisContinente()  {
		return getPais()
				.collect(Collectors.groupingBy(p->p.getContinente()));
	}
	//-Pais a partir de su capital */
	public String getPaisFiltradoPor(String capital)  {
		return getPais()
				.filter(p->p.getCapital() !=null&&p.getCapital().equals(capital))
				.findFirst()//Optional<Pais>
				.map(p->p.getNombre())//Optional<String>
				.orElse(null);
	}
	
}
