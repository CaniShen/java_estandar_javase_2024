package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
<<<<<<< HEAD
import java.util.List;

import model.Pedido;
import utilidades.Util;

public class PedidoService {
	Path pt= Path.of("pedidos.csv");
	//cada pedido se graba en una línea:
	//producto,unidades,fechaPedido
	public void borrarPedidos() {
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoPedido(Pedido pedido) {
		try {
			Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator(), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void nuevoPedido(String producto, int unidades, LocalDate fechaPedido) {
		Pedido p=new Pedido(producto,unidades,fechaPedido);
	
		nuevoPedido(p);
	}
	
	public Pedido pedidoMasReciente() {
			try {
			 return Files.lines(pt) //Stream<String>
					 .map(p->Util.convertirCadenaAPedido(p))//Stream<Pedido>//.map(Util::convertirCadenaAPedido)
					 .max(Comparator.comparing(p->p.getFechaPedido()))//ahora hay que cambiar desde Stream<Strin> A Stream<Pedido>
					 .orElse(null);
			} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
				
	}	
									
	public List<Pedido> pedidoEntreFechas (LocalDate f1, LocalDate f2) {
		try {
			return Files.lines(pt)
						.map(Util::convertirCadenaAPedido)
						.filter(p->p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0)
						.toList();	
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return List.of();
		}

	}	
	

public Pedido pedidoProximoFecha(LocalDate fecha) {
	try {
		return Files.lines(pt)
						.map(Util::convertirCadenaAPedido)
						.min(Comparator.comparingLong(p->Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))))
						.orElse(null);
	}
	catch(IOException ex) {
		ex.printStackTrace();
		return null;
	}
}

	public void eliminarPedido(String producto) {
		try {
			List<String> pedidos = Files.lines(pt).map(Util::convertirCadenaAPedido)// Stream<Pedido>
					.filter(p -> !p.getProducto().equals(producto))// Stream<Pedido>
					.map(Util::convertirPedidoACadena)// Stream<String>
					.toList();
			Files.write(pt, pedidos);
		
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

public List<Pedido> pedidos() {
	try {
		return Files.lines(pt).map(Util::convertirCadenaAPedido)// Stream<Pedido>
				.toList();
	} catch (IOException ex) {
		ex.printStackTrace();
		return null;
	}

=======

import model.Pedido;
import utilidades.Util;

public class PedidoService {
	Path pt= Path.of("pedidos.csv");
	public void borrarPedidos() {
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoPedido(Pedido pedido) {
		try {
			Files.writeString(pt, Util.convertirPedidoACadena(pedido)+System.lineSeparator(), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public Pedido pedidoMasReciente() {
		Pedido p=Util.convertirPedidoACadena()
		return Files.lines(pt)//Stream<String>
				.sorted(Comparator.comparing(c->c.getfechaPedido().));
	}
									
	public ArrayList<Pedido> pedidoEntreFechas (LocalDate f1, LocalDate f2) {
		ArrayList<Pedido> aux=new ArrayList<Pedido>();
		String linea;
		try (FileReader fr = new FileReader(fichero); 
				BufferedReader bf = new BufferedReader(fr);) {
			// mientras haya una nota que leer
			
			while ((linea = bf.readLine()) != null) {
				Pedido p=Util.convertirCadenaAPedido(linea);
				//si fecha del pedido es posterior o igual a f1 y anterior o igual a f2, se incluye
				if(p.getFechaPedido().compareTo(f1)>=0&&p.getFechaPedido().compareTo(f2)<=0) {
					aux.add(p);
				}
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return aux;
	}	
	

public Pedido pedidoProximoFecha(LocalDate fecha) {
	Pedido pAux=new Pedido();
	pAux.setFechaPedido(LocalDate.of(1, 1, 1));
	try(FileReader fr=new FileReader(fichero);
			BufferedReader bf=new BufferedReader(fr);){
		String linea;
		while((linea=bf.readLine())!=null) {
			Pedido p=Util.convertirCadenaAPedido(linea);
			if(Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))<
					Math.abs(ChronoUnit.DAYS.between(pAux.getFechaPedido(), fecha))) {
				pAux=p;
			}
		}
	}
	catch(IOException ex) {
		ex.printStackTrace();
	}
	return pAux;
}

public void eliminarPedido(String producto)  {
	
}

public List<Pedido> pedidos() {
	
>>>>>>> branch 'master' of https://github.com/CaniShen/java_estandar_javese_2024.git
}
}
