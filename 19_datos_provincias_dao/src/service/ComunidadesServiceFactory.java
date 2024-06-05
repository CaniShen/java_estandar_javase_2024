package service;


public class ComunidadesServiceFactory {
	public static ComunidadesService getComunidadesService() {
		return new ComunidadesServiceImpl();
	}
/*	public static ComunidadesDao getComunidadesDao() {
			return new ComunidadesDaoImpl();
	}
	
	public static ProvinciasDao getProvinciasDao()  {
		return new ProvinciasDaoImpl();
		
	}
	
	public static MunicipiosDao getMunicipiosDao()  {
		return MunicipiosDaoImpl();
	
	}	*/
}
