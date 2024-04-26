package principal;

import java.util.Arrays;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Ciudad;

public class LeerJson {

	public static void main(String[] args) {
		String dir="C:\\temp\\ciudades.json";
		Gson gson=new Gson();
		
		try {
			List<Ciudad> ciudades=Arrays.asList(gson.fromJson(new FileReader(dir), Ciudad[].class));
			ciudades.forEach(c->System.out.print(c.getCiudad()+"-"+c.getPoblacion()));
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
