package dao;

import java.sql.Connection;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cuenta;

public class CuentasDaoImpl implements CuentasDao {

	@Override
	public Cuenta findById(int idCuenta) {
		try(Connection con=LocatorConnection.getConnection();) { 
			String sql="select * from cuentas where numeroCuenta=?";	
		}catch(SQLException ex) { 
			  			ex.printStackTrace();
			  
	} 
		return null;
	}

	@Override
	public void updateSaldo(int idCuenta, double nuevaSaldo) {
		// TODO Auto-generated method stub
		
	}

}
