package recurso;

import java.util.ArrayList;
import java.util.Random;

public class GeneradorNumsAleatorios implements Runnable{
	private static ArrayList<Integer> numeros= new ArrayList<>();
	@Override
	public void run() {
		Random random=new Random();
		int numRandom=random.nextInt();
		synchronized (numeros) {
			numeros.add(numRandom);
		}
		
	}
	
	public static int tamanioArray() {
		return numeros.size();
	}

}
