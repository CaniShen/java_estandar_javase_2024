package service;

public class AlumnosServiceFactory {
	private static AlumnosService getAlumnosService() {
		return new AlumnosServiceImpl();
	}
}
