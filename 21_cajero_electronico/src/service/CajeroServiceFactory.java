package service;

public class CajeroServiceFactory {//proporciona un método estático para crear instancias DE CajeroService
	public static CajeroService getCajeroService() {// crear una instancia
						//Metodo estático devuelve una instancia de CajeroService
		return new CajeroServiceImpl();
	}

}
