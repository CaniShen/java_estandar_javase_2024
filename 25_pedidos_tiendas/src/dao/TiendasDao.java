package dao;

import java.util.List;

import model.Pedido;

public interface TiendasDao {
	List<Pedido> getPedidos(String ruta); // dame la ruta y te doy un fichero
}
