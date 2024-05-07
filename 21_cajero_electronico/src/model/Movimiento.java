package model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movimiento {
	private int idMovimiento;
	private String idCuenta;
	private LocalDate fecha;
	private double cantidad;
	private String operacion;

}
