package service;

public class CursosServiceFactory {
	private static CursosService getCursosService() {
		return new CursosServiceImpl();
	}

}
