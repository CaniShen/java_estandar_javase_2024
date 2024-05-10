package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Lanzar dos tareas que se ejecuten concurrentemente.Una de ellas
		//calculará la suma de todo los números entre 1 y 100,y la otra
		//calculará el factorial de un número cualquiera.
		//Cuando las tares finalicen, el programa principal mostrará los resultados.
		//mientras las tareas están ejecución, el programa principal 
		//estará haciendo otra cosas
		ExecutorService executor=Executors.newCachedThreadPool();
		//tarea suma
		
		
		//convencional	
		Future<Integer> f1=executor.submit(()->{                      ///executor.submit(()->IntStream.rangeClosed(1,100).sum()); no puede hacer con Stream. (FUNCIONAL)
			int suma = 0;
			for (int i = 1; i <= 100; i++) {
				suma+=i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return suma;
		});
		//tarea factorial 6
		Future<Integer> f2=executor.submit(()->{
			int p=1;
			for(int i=1;i<6;i++) {
				p*=1;
				try {
					Thread.sleep(100);
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}	
			}
			return p;
		});
		//el main sigue haciendo algo hasta que las tareas terminen,
		//momento en el que se mostrarán los resultados
		while(!f1.isDone()||!f2.isDone())  {
			System.out.println("El main haciendo cosas...");
			Thread.sleep(50);
		}
		System.out.println("Suma de los numeros"+f1.get());
		System.out.println("Factorial de 6 "+f2.get());
		executor.shutdown();
	}
	
	
}
