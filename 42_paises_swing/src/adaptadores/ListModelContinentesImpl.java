package adaptadores;

import java.util.List;

import javax.swing.DefaultListModel;

import service.PaisesServiceFactory;

public class ListModelContinentesImpl extends DefaultListModel<String> {
	List<String> continentes;
	public ListModelContinentesImpl() {
		var paisesService=PaisesServiceFactory.getPaisesService();
		continentes=paisesService.getContinentes();
	}
	@Override
	public int getSize() {
		return continentes.size();
	}
	@Override
	public String getElementAt(int index) {
		return continentes.get(index);
	}
	
}

