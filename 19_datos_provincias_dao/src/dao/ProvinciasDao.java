package dao;

import java.util.List;

import model.Provincia;

public interface ProvinciasDao {
	
	/*public void save (Provincia provincia);*/
	void saveProvincias(List<Provincia> provincias);
	
	//public Provincia findByName(String nombreProvincia);
	List<String> findCodigos();
	
	static ProvinciasDao of() {
		// TODO Auto-generated method stub
		return new ProvinciasDaoImpl();
	}
	
}
