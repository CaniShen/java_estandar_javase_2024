package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.EmpleadosService;
class TestEmpleadosService {
	static EmpleadosService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service=new EmpleadosService();
	}

	@Test
	void testEmpleadosDepartamento() {
		assertEquals(2, service.empleadosDepartamento("RRHH").size());
	}

	@Test
	void testEmpleadoMayorSalario() {

		assertEquals("Javier", service.empleadoMayorSalario().getEmpleado());
	}

	@Test
	void testDepartamentos() {
		assertEquals(3, service.departamentos().size());
	}

}
