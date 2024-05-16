package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;

import model.Provincia;
import service.DatosProvinciasServiceFactory;

public class ComboBoxModelProvinciasImpl extends  DefaultComboBoxModel <String> {
		List<String>provincias;
		public ComboBoxModelProvinciasImpl(String comunidad) {
			var provinciasService=DatosProvinciasServiceFactory.getDatosProvinciasService();
			provincias=provinciasService.provinciasFiltradosPor(comunidad).stream().map(a->a.getNombreProvincia()).toList();
			//provincias=provinciasService.provinciasFiltradosPor(comunidad);
		}
		@Override
		public int getSize() {
			// TODO Auto-generated method stub
			return provincias.size();
		}
		@Override
		public String getElementAt(int index) {
			// TODO Auto-generated method stub
			return provincias.get(index);
		}
		
	
		
}
