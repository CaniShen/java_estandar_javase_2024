package dao;

import java.util.List;

import model.Municipio;

public interface MunicipiosDao {
	
	//CRUD
	//Create
	//Read
	//Update
	//Delete
	
	//	findAll
	//	findById
	//	UpdateById
	//	Update
	//	deleteById
	//	.....

	public void save(Municipio municipio);
//	void saveMunicipios(List<Municipio> municipios);
	
	public Municipio findByName(String nombre);
	
//	List<String> findCodigo();

	static MunicipiosDao of() {
		
		return new MunicipiosDaoImpl();
	}
	
	

}
