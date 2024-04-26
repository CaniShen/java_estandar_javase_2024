package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;

public class EmpleadosService {
	/*Implementar lógica de negocio de una aplicación que proporcione los siguientes métodos

	-Lista de empleados de un determinado departamento
	-Empleado con mayor salario
	-Lista de departamentos */
	String ruta="Empleados.json";
	private Stream<Empleado> getEmpleados() {
		try {
			Gson gson=new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(ruta), Empleado[].class));
		}
		catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
	}
}
	
	public List<Empleado> empleadosDepartamento(String departamento) {
		return getEmpleados()//Stream<Empleado>
				.filter(e->e.getDepartamento().equals(departamento))
				.toList();
		
	}
	
	public Empleado empleadoMayorSalario() {
		return getEmpleados()//Stream<Empleado>
				.max(Comparator.comparingDouble(e->e.getSalario()))
				.orElse(null);
	}
	
	public List<String>departamentos() {
		return getEmpleados()//Stream<Empleado>
				.map(e->e.getDepartamento())//Stream<String>
				.distinct()
				.toList();
	}
}
