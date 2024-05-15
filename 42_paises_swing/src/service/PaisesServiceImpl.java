package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

/*Implementar lógica de negocio de una aplicación que proporcione información
sobre paises. Cada pais se caracteriza por: nombre,continente,capital,habitantes

-Lista de continentes
-Lista de paises a partir del continente
-Pais más poblado
-Tabla con paises agurpados por continente
-Pais a partir de su capital */
public class PaisesServiceImpl implements PaisesService {
	private  Stream<Pais> getStreamPaises() {
		Gson gson=new Gson();
		String url="https://restcountries.com/v2/all";
		//creamos objeto request que configura la petición
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();
		//creamos objeto client para hacer la llamada
		HttpClient client=HttpClient.newBuilder()
					.build();
		//realizamos la llamada
		try {
			HttpResponse<String> respuesta=client.send(request,BodyHandlers.ofString());
			return Arrays.stream(gson.fromJson(respuesta.body(),Pais[].class));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return Stream.empty();
		}
		
	}
	//-Lista de continentes
	@Override
	public List<String> getContinentes() {
		return getStreamPaises() //Stream<Pais>
				.map(c->c.getContinente()) //Stream<String>
				.distinct()
				.toList();
				
	}
	//-Lista de paises a partir del continente
	@Override
	public List<Pais> getPaisesFiltradosPor(String continente) {
		return getStreamPaises() //Stream<Pais>
				.filter(p->p.getContinente().equalsIgnoreCase(continente))//Stream<Pais>?????????????
				.toList();
	}
	//-Pais más poblado
	@Override
	public  Optional<Pais> getPaisMasPoblado() {
		return getStreamPaises()//Stream<Pais>
				.max(Comparator.comparingLong(p->p.getPoblacion()));
	}
	//-Tabla con paises agurpados por continente
	@Override
	public  Map<String, List<Pais>> getTablaPaisContinente()  {
		return getStreamPaises()
				.collect(Collectors.groupingBy(p->p.getContinente()));
	}
	//-Pais a partir de su capital */
	@Override
	public String getPaisFiltradoPor(String capital)  {
		return getStreamPaises()
				.filter(p->p.getCapital() !=null&&p.getCapital().equals(capital))
				.findFirst()//Optional<Pais>
				.map(p->p.getNombre())//Optional<String>
				.orElse(null);
	}
	
}
