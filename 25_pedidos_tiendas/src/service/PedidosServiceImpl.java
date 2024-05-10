package service;

import java.util.List;

import dao.DaoFactory;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {

	@Override
	public List<Pedido> pedidosTienda(String ruta, String Tienda) {
		TiendasDao fDao=DaoFactory.getPedidosDao();
		List<Pedido> pedidosFicheros=fDao.getPedido(ruta);
		//recorremos los pedidos que llegan del fichero y le asignamos
		//Tienda
		pedidosFicheros.forEach(p>p.setTienda(tienda));
		
		return pedidosFichero;
	}

	@Override
	public void guardarPedido(List<Pedido> pedidos) {
		// TODO Auto-generated method stub

	}

}
