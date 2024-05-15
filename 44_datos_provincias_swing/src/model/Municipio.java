package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Municipio {
	@SerializedName("NOMBRE")
	private String nombreMunicipio;
	@SerializedName("NOMBRE_PROVINCIA")
	private String nombreProvincia;
	@SerializedName("POBLACION_CAPITAL")
	private String poblacion;
	@SerializedName("ALTITUD")
	private int altitud;
	@SerializedName("SUPERFICIE")
	private Double superficie;
}
