package service;

import java.util.List;

import dao.ClientesDao;
import dao.CuentasDao;
import dao.MovimientosDao;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

public class CajeroServiceImpl implements CajeroService {
	ClientesDao clientesDao;
	CuentasDao cuentasDao;
	MovimientosDao movimientosDao;
	
	public CajeroServiceImpl() {
		clientesDao=ClientesDao.of();
		cuentasDao=CuentasDao.of();
		movimientosDao=MovimientosDao.of();
	}

	@Override
	public Cuenta obtenerCuenta(int idCuenta) {
		Cuenta cuenta= cuentasDao.findById(idCuenta);
		if (cuentasDao.findById(idCuenta) != null) {
			return cuenta;
		}
		return null;
	}

	@Override
	public Cuenta extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta = cuentasDao.findById(idCuenta);
		if (cuenta != null && cuenta.getSaldo() >= cantidad) {

			cuentasDao.updateSaldo(idCuenta, cuenta.getSaldo() - cantidad);
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			return cuenta;
		}
		return null;
	}

	@Override
	public Cuenta ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta=cuentasDao.findById(idCuenta);
		if (cuenta !=null) {
			cuentasDao.updateSaldo(idCuenta, cuenta.getSaldo() + cantidad);
			cuenta.setSaldo(cuenta.getSaldo()+cantidad);
			return cuenta;
		}
		return null;
	}

	@Override
	public boolean transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		Cuenta cuentaOri=cuentasDao.findById(idCuentaOrigen);
		Cuenta cuentaDes=cuentasDao.findById(idCuentaDestino);
		if(cuentaOri !=null&&cuentaOri.getSaldo()>=cantidad
				&&cuentaDes !=null) {
			cuentasDao.updateSaldo(idCuentaDestino, cuentaDes.getSaldo() + cantidad);
			cuentasDao.updateSaldo(idCuentaOrigen, cuentaDes.getSaldo() - cantidad);
			cuentaOri.setSaldo(cuentaOri.getSaldo() - cantidad);
			cuentaDes.setSaldo(cuentaDes.getSaldo() + cantidad);
			return true;
		}
			return false;
		}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		
		return clientesDao.findByCuenta(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {
		
		return movimientosDao.findByCuenta(idCuenta);
	}

	@Override
	public double obtenerSaldo(int idCuenta) {
		Cuenta cuenta=cuentasDao.findById(idCuenta);
		
		return cuenta.getSaldo();
	}

}
