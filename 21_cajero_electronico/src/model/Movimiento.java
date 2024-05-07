package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movimiento {
	private int idMovimiento;
	private int idCuenta;
	private LocalDateTime fecha;
	private double cantidad;
	private String operacion;

}
