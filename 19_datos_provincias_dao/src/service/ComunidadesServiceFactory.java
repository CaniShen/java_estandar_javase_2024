package service;

import dao.ComunidadesDao;
import dao.ComunidadesDaoImpl;
import dao.MunicipiosDao;
import dao.ProvinciasDao;
import dao.ProvinciasDaoImpl;

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
