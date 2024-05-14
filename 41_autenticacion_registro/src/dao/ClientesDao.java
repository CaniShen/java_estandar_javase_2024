package dao;

import model.Cliente;

public interface ClientesDao {
	Cliente findByUsuario(String usuario);

	void save(Cliente cliente);

}
