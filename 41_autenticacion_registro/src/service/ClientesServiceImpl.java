package service;

import dao.ClientesDao;
import dao.ClientesDaoFactory;
import model.Cliente;

public class ClientesServiceImpl implements ClientesService {
	ClientesDao clientesDao;
	public ClientesServiceImpl() {//constructor de la clase
		clientesDao=ClientesDaoFactory.getClientesDao(); //crear la instancia,llamar al metodo
	}

	@Override
	public boolean autenticar(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuario(usuario);
		return cliente!=null&cliente.getPassword().equals(password);
		
			
	}

	@Override
	public boolean registrar(Cliente cliente) {
		
		if(clientesDao.findByUsuario(cliente.getUsuario())!=null) {
			return false;
		}
		
		clientesDao.save(cliente);
		return true;
			
		}
	}


