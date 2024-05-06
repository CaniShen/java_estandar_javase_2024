package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ContactosDao;
import model.Contacto;

/*1.-Nuevo Contacto
2.-Eliminar Contacto
3.-Actualizar edad
4.-Salir

1: Se piden los datos del nuevo contacto y se guarda
2: Solicita el email y borra el contacto con dicho email
3: Solicita email y nueva edad, y sustituye la edad anterior por la nueva en ese contacto */
public class ContactosServiceImpl implements ContactosService {

	ContactosDao contactosDao;

	public ContactosServiceImpl() {
		contactosDao = ContactosDao.of();

	}

	// si ya hay un contacto con ese email, no se añadirá y devolverá false.
	// Es decir, no se admitirán contactos con email duplicado.
	@Override
	public boolean nuevoContacto(Contacto contacto) {

		if (contactosDao.findByEmail(contacto.getEmail()) != null) {
			return false;
		}
		contactosDao.save(contacto);
		return true;

	}

//devuelve el contacto eliminado.Si no se ha eliminado ninguno, de vuelve null.
	@Override
	public Contacto eliminarContacto(String email) {
		Contacto contacto = contactosDao.findByEmail(email);
		if (contacto == null) {
			return null;
		}
		contactosDao.delateByEmail(email);
		return contacto;

	}

	@Override
	public boolean actualizarContacto(String email, int nuevaEdad) {
		Contacto contacto = contactosDao.findByEmail(email);
		if (contacto != null) {
			contacto.setEdad(nuevaEdad);
			contactosDao.update(contacto);
			return true;
		}
		return false;

	}

//Buscar contacto por su clave primaria
	@Override
	public Contacto buscarContactoPorId(int idContacto) {
		return contactosDao.findById(idContacto);

	}

//Recuperar todos los contactos
	@Override
	public List<Contacto> getContactos() {
		return contactosDao.findAll();
	}

}
