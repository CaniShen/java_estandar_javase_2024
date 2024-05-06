package view;

import java.util.ArrayList;
import java.util.List;

import model.Comunidad;
import model.Municipio;
import model.Provincia;
import service.ComunidadesService;
import service.ComunidadesServiceImpl;

public class Poblaciones {
	
	
	public static void main(String[] args) {
		ComunidadesService comService=new ComunidadesServiceImpl();
		int numComunidadesSave = comService.saveComunidades(generarDatosComunidades());
		int numMunicipiosSave = comService.saveMunicipios(generarDatosMunicipio());
		int numProvinciasSave = comService.saveProvincias(generarDatosProvincia());
		
		System.out.println("comunidades: " + numComunidadesSave);
		System.out.println("municipios: " + numMunicipiosSave);
		System.out.println("provincias: " + numProvinciasSave);
	}
	
	public static List<Comunidad> generarDatosComunidades() {
		List<Comunidad> comunidades = new ArrayList<Comunidad>();
		comunidades.add(new Comunidad("1","Pepe"));
		comunidades.add(new Comunidad("3","Cani"));
		comunidades.add(new Comunidad("4","Jorge"));
		comunidades.add(new Comunidad("2","Cani"));
		
		return comunidades;
	}
	
	public static List<Municipio> generarDatosMunicipio() {
		List<Municipio> municipios = new ArrayList<Municipio>();
		municipios.add(new Municipio("1","Pepe","a", 1, 2, 3));
		municipios.add(new Municipio("3","Cani","a", 1, 2, 3));
		municipios.add(new Municipio("4","Jorge","a", 1, 2, 3));
		municipios.add(new Municipio("5","Jorge","a", 1, 2, 3));
		
		return municipios;
	}
	
	public static List<Provincia> generarDatosProvincia() {
		List<Provincia> provincias = new ArrayList<Provincia>();
		provincias.add(new Provincia("1","Pepe","a", "1"));
		provincias.add(new Provincia("3","Cani","b", "1"));
		provincias.add(new Provincia("4","Jorge","a", "1"));
		provincias.add(new Provincia("5","Jorge","a", "1"));
		provincias.add(new Provincia("6","Cani","a", "1"));
		
		return provincias;
	}

}
