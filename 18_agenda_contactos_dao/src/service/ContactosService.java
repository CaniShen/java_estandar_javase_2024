package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	//si ya hay un contacto con ese email, no se añadirá y devolverá false.
	//Es decir, no se admitirán contactos con email duplicado.
	boolean nuevoContacto(Contacto contacto);

	//devuelve el contacto eliminado.Si no se ha eliminado ninguno, de vuelve null.
	Contacto eliminarContacto(String email);

	boolean actualizarContacto(String email, int nuevaEdad);

	//Buscar contacto por su clave primaria
	Contacto buscarContactoPorId(int idContacto);

	//Recuperar todos los contactos
	List<Contacto> getContactos();

}