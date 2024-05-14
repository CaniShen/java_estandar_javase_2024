package dao;

public class ClientesDaoFactory {

	public static ClientesDao getClientesDao() {//使抽象化
		// TODO Auto-generated method stub
		return new ClientesDaoImpl();
	}

}
