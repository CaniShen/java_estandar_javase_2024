package principal;

import tareas.TareaAscendente;
import tareas.TareaDecendente;

public class Lanzador {

	public static void main(String[] args) {
		var t1=new TareaAscendente();
		var t2=new TareaDecendente();
		t1.start();
		t2.start();

	}

}
