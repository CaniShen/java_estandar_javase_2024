package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.JsonMunicipio;
import model.JsonProvincia;
import model.Municipio;
import model.Provincia;

public class DatosProvinciasServiceImpl implements DatosProvinciasService {
	private Stream <Provincia> getStreamProvincias() {
		Gson gson=new Gson();
		String url="https://www.el-tiempo.net/api/json/v2/provincias";
		//creamos objeto request que configura la petición
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();
		//creamos objeto cliente para hacer la llamada
		HttpClient client=HttpClient.newBuilder()
				.build();
		//realizamos la llamada
		try {
			HttpResponse<String> respuesta=client.send(request, BodyHandlers.ofString());
		 	return gson.fromJson(respuesta.body(),JsonProvincia.class).getProvincias().stream();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	private  Stream<Municipio> getStreamMunicipiosProvincia(String codigo) {
		Gson gson = new Gson();
		String url="https://www.el-tiempo.net/api/json/v2/provincias/"+codigo+"/municipios";
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
			HttpResponse<String> respuesta=client.send(request, BodyHandlers.ofString());
		 	return gson.fromJson(respuesta.body(),JsonMunicipio.class).getMunicipios().stream();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	@Override
	public List<String> comunidades(){
		return getStreamProvincias()
				.map(p->p.getComunidadAutonoma())
				.distinct()
				.toList();
	}
	@Override
	public List<Provincia> provinciasFiltradosPor(String comunidad) {
		return getStreamProvincias()
				.filter(p->p.getComunidadAutonoma().equals(comunidad))
				.toList();
	}
	@Override
	public List<Municipio> municipios(){
		return getStreamProvincias()//Stream<Provincia>
				.flatMap(p->getStreamMunicipiosProvincia(p.getCodigoProvincia()))//Stream<Municipio>
				.toList();
	}
	@Override
	public List<Municipio> municipiosComunidad(String comunidad){
		return getStreamProvincias()
				.filter(p->p.getComunidadAutonoma().equals(comunidad))
				.flatMap(p -> getStreamMunicipiosProvincia(p.getCodigoProvincia()))
				.toList();
	}
	@Override
	public List<Municipio> municipiosFiltradosPor(String provincia) {
		// TODO Auto-generated method stub
		return getStreamProvincias()
				.filter(p->p.getNombreProvincia().equals(provincia))
				.flatMap(p->getStreamMunicipiosProvincia(p.getCodigoProvincia()))
				.toList();
	}
}



