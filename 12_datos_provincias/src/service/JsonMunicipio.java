package service;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Municipio;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonMunicipio {
	public List <Municipio> municipios;
}
