package service;

import java.util.List;

import dao.DaoFactory;
import dao.PedidosDao;
import dao.TiendasDao;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {


	private List<Pedido> pedidosTienda(String ruta, String tienda) {
		TiendasDao fDao=DaoFactory.getFicheroPedidosDao();
		List<Pedido> pedidosFicheros=fDao.getPedidos(ruta);
		//recorremos los pedidos que llegan del fichero y le asignamos
		//Tienda
		pedidosFicheros.forEach(p->p.setTienda(tienda));
		
		return pedidosFicheros;
	}

	private void guardarPedidos(List<Pedido> pedidos) {
		PedidosDao pDao=DaoFactory.getPedidosDao();
		//recorremos lista de pedidos y los guardamos
		pedidos.forEach(p->pDao.save(p));

	}

	@Override
	public void procesarPedidos(String ruta, String tienda) {
		guardarPedidos(pedidosTienda(ruta,tienda));
		
	}

}
