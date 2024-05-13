package principal;


import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class PruebaAgregar {

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> lista=new CopyOnWriteArrayList<Integer>();
		ExecutorService executor=Executors.newCachedThreadPool();
		for(int i=1;i<1000000;i++)  {
			executor.submit(()->lista.add((int)Math.random()*500+1));
//			Thread hilo=new Thread(new GeneradorNumsAleatorios());  ArrayList no es un hilo segura
//			hilo.start();
		} 
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("El tamaño del Array es: "+ lista.size());
	}

}
