package dao;

import java.util.List;

import model.Pedido;

public interface TiendasDao {
	List<Pedido> getPedido(String ruta); // dame la ruta y te doy un fichero
}
