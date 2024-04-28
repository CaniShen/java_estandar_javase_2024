package principal;

import service.PaisesService;

public class MostrarDatos {

	public static void main(String[] args) {
		var paisesService=new PaisesService();
		paisesService.listaContinente().forEach(t-> System.out.println(t));

	}

}
