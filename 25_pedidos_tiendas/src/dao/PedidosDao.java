package dao;

import model.Pedido;

public interface PedidosDao {
	void save (Pedido pedido);

/*	static PedidosDao of() {
		return new PedidosDaoImpl();
	}*/
}
