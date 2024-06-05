package graficos;

import javax.swing.DefaultComboBoxModel;

import service.CajeroServiceFactory;

public class ComboBoxModelTitularesImpl extends DefaultComboBoxModel<Cliente> {
	
	public ComboBoxModelTitularesImpl(int numeroCuenta) {
		super(CajeroServiceFactory.getCajeroService().obtenerCuenta(numeroCuenta).to Array)
	}

}
