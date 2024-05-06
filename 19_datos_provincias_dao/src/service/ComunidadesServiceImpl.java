package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		public ComunidadesServiceImpl() {
			comunidadesDao = ComunidadesDao.of();
			municipiosDao = MunicipiosDao.of();
			provinciasDao = ProvinciasDao.of();
			
		}
	
	@Override
	public int saveComunidades(List<Comunidad> comunidades)  {
		int i=0;
		for(Comunidad comunidad:comunidades) {
			if (comunidadesDao.findByComunidad(comunidad.getNombre()) ==null) {
				comunidadesDao.save(comunidad);
				i++;
			}
	
		}
		return i;
	}

	@Override
	public int saveProvincias(List<Provincia> provincias) {
		int i=0;
		for(Provincia provincia:provincias) {
			if (provinciasDao.findByName(provincia.getNombre()) ==null) {
				provinciasDao.save(provincia);
				i++;
			}
	
		}
		return i;
	}

	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		int i=0;
		for(Municipio municipio:municipios) {
			if (municipiosDao.findByName(municipio.getNombre()) ==null) {
				municipiosDao.save(municipio);
				i++;
			}
	
		}
		return i;
	}

	
/*	public boolean existeComunidad(int codigo)  {
		if (comunidadesDao.findByComunidad(codigo!))
		return false;
	}
	public void borrarComunidades()  {
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
		String sql="delete from comunidades";
		PreparedStatement ps=con.prepareStatement(sql);
			ps.execute();
		
	}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void saveProvincias(List<Provincia> provincias) {
		try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			String sql="insert into provincias(codigo,nombre,codComunidad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancalemos autocomit
			for(Provincia p:provincias){
				ps.setString(1, p.getCodigo());
				ps.setString(2, p.getNombre());
				ps.setString(3, p.getCodComunidad());
				ps.execute();
			}
			con.commit();//confirmamos tx si no ha habido fallos.
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void saveMunicipios(List<Municipio> municipios) {
		try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			String sql="insert into municipios(codigo,nombre,codProvincia,superficie,altitud,poblacion) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			con.setAutoCommit(false);//cancalemos autocomit
			for(Municipio m:municipios){
				ps.setString(1, m.getCodigo());
				ps.setString(2, m.getNombre());
				ps.setString(3, m.getCodProvincia());
				ps.setDouble(4, m.getSuperficie());
				ps.setInt(5, m.getAltitud());
				ps.setInt(6, m.getPoblacion());
				ps.execute();
			}
			con.commit();//confirmamos tx si no ha habido fallos.
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public int poblacionTotalProvincia(String codigoProvincia) {
		try (Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			String sql="select sum(poblacion) from municipios where codProvincia=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, codigoProvincia);
			ResultSet rs=ps.executeQuery();
			if (rs.next())  {
				return rs.getInt(1);
			}
			return 0;
		
		
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			
			return 0;
		}
	
}*/
	
	
	

}