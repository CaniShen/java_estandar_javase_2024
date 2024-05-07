package dao;

import model.Cuenta;

public interface CuentasDao {
	//CRUD
	//Create
	//Read
	//Update
	//Delete
	
	/*double obtener(Cuenta cuenta);
	boolean existeNumeroCuenta(int numeroCuenta);
	boolean sufiSaldo(double saldo); mal*/
	Cuenta findById(int idCuenta);
	void updateSaldo(int idCuenta, double nuevaSaldo); 
	
	static CuentasDao of()  {
		return new CuentasDaoImpl();
	}

}
