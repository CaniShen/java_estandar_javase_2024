package service;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.stream.events.StartDocument;

import exceptions.ErrorFuenteDatosException;

////Realizar una nueva versión del programa de las notas. Al iniciar el programa
//aparecerá el siguiente menú:
//1.- Nueva nota
//2.- Calcular media
//3.- Notas extremas
//4.- Ver todas
//5.- Salir 
public class NotasService {
	Path pt = Path.of("notas.txt");

	public void borrarNotas()	{
		try {
			Files.deleteIfExists(pt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregarNota(double nota) {
		try {
			Files.writeString(pt, nota+System.lineSeparator(), StandardOpenOption.APPEND,StandardOpenOption.CREATE);
	}
		catch (IOException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
}
	public double media() throws ErrorFuenteDatosException {//propagar la excepción.

		try {
			return Files.lines(pt)
					.collect(Collectors.averagingDouble(s->Double.parseDouble(s)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosException();//provoca la excepción.
		}
	
	}

	public double max() throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt)
					.max(Comparator.comparingDouble(s->Double.parseDouble(s)))//Optional<String>
					.map(s->Double.parseDouble(s))//Optional<Double>
					.orElse(0.0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}

	}

	public double min() throws ErrorFuenteDatosException {
		try {
			return Files.lines(pt)
					.min(Comparator.comparingDouble(s->Double.parseDouble(s)))//Optional<String>
					.map(s->Double.parseDouble(s))
					.orElse(0.0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
	}
	public List<Double> obtenerNotas() throws ErrorFuenteDatosException {

		try {
			return Files.lines(pt) //Stream<String>
					.map(s->Double.parseDouble(s))//Stream<Double>
					.toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ErrorFuenteDatosException();
		}
}
}