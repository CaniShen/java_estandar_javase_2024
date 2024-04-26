package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Pais {

	private String nombre;
	private String continente;
	private String capital;
	private long habitantes;
	

}
