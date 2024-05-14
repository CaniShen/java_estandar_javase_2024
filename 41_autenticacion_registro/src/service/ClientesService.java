package service;

import model.Cliente;

public interface ClientesService {
	boolean autenticar(String usuario, String password);
	boolean registrar(Cliente cliente);
	
}
