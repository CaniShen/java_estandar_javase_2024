package principal;

import graficos.MiVentana;

public class Main {

	public static void main(String[] args) {
		new MiVentana();//otro hilo, el main es un hilo.
		new MiVentana();

	}

}
