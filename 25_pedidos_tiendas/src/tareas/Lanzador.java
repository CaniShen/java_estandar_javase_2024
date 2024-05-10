package tareas;

import java.io.IOException;

import service.PedidosService;

public class Lanzador {
	static String ruta1="C:\\temp\\pedidos\\tienda1.json";
	static String ruta2="C:\\temp\\pedidos\\tienda2.json";
	static String ruta3="C:\\temp\\pedidos\\tienda3.json";
	public static void main(String[] args) throws IOException {
		PedidosService service=PedidosServiceFactory.getPedidosService();
		new Thread(()->service.guardarPedido(service.pedidosTienda(ruta1,"tienda1"))).start();
		new Thread(()->service.guardarPedido(service.pedidosTienda(ruta1,"tienda2"))).start();
		new Thread(()->service.guardarPedido(service.pedidosTienda(ruta1,"tienda3"))).start();
		System.out.println("Pedidos enviado. Pulse tecla para continuar");
		System.in.read();

	}

}
