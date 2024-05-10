package tareas;

public class TareaDecendente implements Runnable {

	@Override
	public void run() {
		for(int i=100;i>1;i--) {
			System.out.println("Descendente: "+i);
			try {
				Thread.sleep(100);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
