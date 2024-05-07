package principal;

import utilidades.Conector;


public class TestConector {

	public static void main(String[] args) {
		Conector conector= new Conector.ConectorBuilder()  //la clase contenedora es Conector.
				.dir("prueba")
				.estado(true)
				.protocolo("http")
				.build();
	}

}