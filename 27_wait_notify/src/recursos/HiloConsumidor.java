package recursos;

public class HiloConsumidor implements Runnable {
	private Recurso recurso;
	public HiloConsumidor(Recurso recurso) {
		this.recurso=recurso;
	}
 
	@Override
	public void run() {
		while(true)  {
			synchronized (recurso) {
				if(recurso.isVacio()) {
					try {
						System.out.println("Recurso lleno esperando...");
						recurso.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Consumiendo: "+recurso.sacar());
				recurso.notify();
				
			}
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
