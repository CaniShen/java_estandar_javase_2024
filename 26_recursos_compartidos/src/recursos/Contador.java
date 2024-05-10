package recursos;

public class Contador {
	private int valor;
	public synchronized void incrementar() {
		//synchronized (this) {
		int temp=valor;
		temp=temp+1;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		valor=temp;
		//}
	}
	public int getValor() {
		return valor;
	}
}
