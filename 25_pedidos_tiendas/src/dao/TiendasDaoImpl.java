package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pedido;
import serializacion.DeserializadorFecha;

public class TiendasDaoImpl implements TiendasDao {

	private Stream<Pedido> pedidosFichero(String ruta) {// metodo privado--recibe uan ruta de String y devuelve un Pedido de Stream
		Gson gson = new GsonBuilder()// GsonBuilder-//JSON---->INSTANCIA JAVA
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) // GsonBuilder
				.create();
		try (FileReader reader = new FileReader(ruta);) {//Read fichero
			Pedido[] pedidos = gson.fromJson(reader, Pedido[].class);//transforma desdeJson a Pedido[]
			return Arrays.stream(pedidos); //trasforma desde Array a Stream
		} 
		catch (IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}

	@Override
	public List<Pedido> getPedidos(String ruta) {
		return pedidosFichero(ruta).
				toList();
	}


}
