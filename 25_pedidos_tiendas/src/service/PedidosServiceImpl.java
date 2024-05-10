package service;

import java.util.List;

import dao.DaoFactory;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {


	private List<Pedido> pedidosTienda(String ruta, String tienda) {
		TiendasDao fDao=DaoFactory.getPedidosDao();
		List<Pedido> pedidosFicheros=fDao.getPedido(ruta);
		//recorremos los pedidos que llegan del fichero y le asignamos
		//Tienda
		pedidosFicheros.forEach(p>p.setTienda(tienda));
		
		return pedidosFicheros;
	}

	private void guardarPedido(List<Pedido> pedidos) {
		
	}

	@Override
	public void procesarPedidos(String ruta, String tienda) {
		// TODO Auto-generated method stub
		
	}

}
