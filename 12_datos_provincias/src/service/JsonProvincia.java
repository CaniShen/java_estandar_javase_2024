package service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Provincia;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JsonProvincia {
		private List<Provincia> provincias;
}
