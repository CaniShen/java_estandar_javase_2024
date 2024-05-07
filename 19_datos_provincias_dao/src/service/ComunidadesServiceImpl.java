package service;

import java.util.List;

import dao.ComunidadesDao;
import dao.MunicipiosDao;
import dao.ProvinciasDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public class ComunidadesServiceImpl implements ComunidadesService {

	ComunidadesDao comunidadesDao;
	MunicipiosDao municipiosDao;
	ProvinciasDao provinciasDao;

	public ComunidadesServiceImpl() {// crear el constructor
		comunidadesDao = ComunidadesDao.of();
		municipiosDao = MunicipiosDao.of();
		provinciasDao = ProvinciasDao.of();
		
	/*comunidadesDao=ComunidadesDaoFactory.ge*/

	}

	@Override
	/*
	 * public int saveComunidades(List<Comunidad> comunidades) { int i=0;
	 * for(Comunidad comunidad:comunidades) { if
	 * (comunidadesDao.findByComunidad(comunidad.getNombre()) ==null) {
	 * comunidadesDao.save(comunidad); i++; }
	 * 
	 * } return i; }
	 */
	public int saveComunidades(List<Comunidad> comunidades) {
		int i = 0;
		/*
		 * Solucion 1: // se hace un forEach porque el parámetro es una Lista
		 * for(Comunidad c:comunidades) { if
		 * (!comunidadesDao.existComunidad(c.getCodigo())) { comunidadesDao.save(c);
		 * i++; } } return i;
		 */
//Solucion 2:
		List<Comunidad> aux = comunidades.stream().filter(c -> !comunidadesDao.existComunidad(c.getCodigo())).toList();
		comunidadesDao.save(aux);
		return aux.size();
		/*
		 * funcional return (int)comunidades.stream()
		 * .filter(c->!comunidadesDao.existComunidad(c.getCodigo()))
		 * .peek(c->comunidadesDao.save(c)) .count();
		 */

	}

	@Override
/*	public int saveProvincias(List<Provincia> provincias) {
		int i = 0;
		for (Provincia provincia : provincias) {
			if (provinciasDao.findByName(provincia.getNombre()) == null) {
				provinciasDao.save(provincia);
				i++;
			}

		}
		return i;
	}*/
	public int saveProvincias (List<Provincia> provincias) {
		List<String> codigo= provinciasDao.findCodigos();
		List<Provincia> aux= provincias.stream()
				.filter(p->codigo.contains(p.getCodigo()))
				.toList();
		provinciasDao.saveProvincias(provincias);
		return aux.size();
				
	}

	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		int i = 0;
		for (Municipio municipio : municipios) {
			if (municipiosDao.findByName(municipio.getNombre()) == null) {
				municipiosDao.save(municipio);
				i++;
			}

		}
		return i;
	}

	/*
	 * public boolean existeComunidad(int codigo) { if
	 * (comunidadesDao.findByComunidad(codigo!)) return false; } public void
	 * borrarComunidades() { try(Connection
	 * con=DriverManager.getConnection(cadenaConexion,usuario,password);){ String
	 * sql="delete from comunidades"; PreparedStatement
	 * ps=con.prepareStatement(sql); ps.execute();
	 * 
	 * } catch(SQLException ex) { ex.printStackTrace(); } }
	 * 
	 * @Override public void saveProvincias(List<Provincia> provincias) { try
	 * (Connection
	 * con=DriverManager.getConnection(cadenaConexion,usuario,password);){ String
	 * sql="insert into provincias(codigo,nombre,codComunidad) values(?,?,?)";
	 * PreparedStatement ps=con.prepareStatement(sql);
	 * con.setAutoCommit(false);//cancalemos autocomit for(Provincia p:provincias){
	 * ps.setString(1, p.getCodigo()); ps.setString(2, p.getNombre());
	 * ps.setString(3, p.getCodComunidad()); ps.execute(); }
	 * con.commit();//confirmamos tx si no ha habido fallos. } catch(SQLException
	 * ex) { ex.printStackTrace(); } }
	 * 
	 * @Override public void saveMunicipios(List<Municipio> municipios) { try
	 * (Connection
	 * con=DriverManager.getConnection(cadenaConexion,usuario,password);){ String
	 * sql="insert into municipios(codigo,nombre,codProvincia,superficie,altitud,poblacion) values(?,?,?,?,?,?)"
	 * ; PreparedStatement ps=con.prepareStatement(sql);
	 * con.setAutoCommit(false);//cancalemos autocomit for(Municipio m:municipios){
	 * ps.setString(1, m.getCodigo()); ps.setString(2, m.getNombre());
	 * ps.setString(3, m.getCodProvincia()); ps.setDouble(4, m.getSuperficie());
	 * ps.setInt(5, m.getAltitud()); ps.setInt(6, m.getPoblacion()); ps.execute(); }
	 * con.commit();//confirmamos tx si no ha habido fallos. } catch(SQLException
	 * ex) { ex.printStackTrace(); } }
	 * 
	 * public int poblacionTotalProvincia(String codigoProvincia) { try (Connection
	 * con=DriverManager.getConnection(cadenaConexion,usuario,password);){ String
	 * sql="select sum(poblacion) from municipios where codProvincia=?";
	 * PreparedStatement ps=con.prepareStatement(sql); ps.setString(1,
	 * codigoProvincia); ResultSet rs=ps.executeQuery(); if (rs.next()) { return
	 * rs.getInt(1); } return 0;
	 * 
	 * 
	 * } catch(SQLException ex) { ex.printStackTrace();
	 * 
	 * return 0; }
	 * 
	 * }
	 */

}