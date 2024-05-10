package principal;

import tareas.TareaAscendente;
import tareas.TareaDecendente;

public class Lanzador {

	public static void main(String[] args) {
		
		var t1=new TareaAscendente();
		var t2=new TareaDecendente();
		Thread ta=new Thread(t1);
		Thread td=new Thread(t2);
		ta.start();
		td.start();

	}

}
