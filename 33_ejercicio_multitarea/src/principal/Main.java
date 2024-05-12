package principal;

import recurso.GeneradorNumsAleatorios;

public class Main {

	public static void main(String[] args) {
		for(int i=0;i<1000000;i++)  {
			Thread hilo=new Thread(new GeneradorNumsAleatorios());
			hilo.start();
		} 
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("El tamaño del Array es: "+ GeneradorNumsAleatorios.tamanioArray());
	}

}
