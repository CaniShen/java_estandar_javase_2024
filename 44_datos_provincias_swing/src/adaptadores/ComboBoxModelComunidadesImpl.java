package adaptadores;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosProvinciasServiceFactory;





public class ComboBoxModelComunidadesImpl extends DefaultComboBoxModel <String> {
	List<String> comunidades;
	//crear el contructor.
	public ComboBoxModelComunidadesImpl() {
		var comunidadesService=DatosProvinciasServiceFactory.getDatosProvinciasService();
		comunidades=comunidadesService.comunidades();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return comunidades.size();
	}
	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return comunidades.get(index);
	}
	
}
