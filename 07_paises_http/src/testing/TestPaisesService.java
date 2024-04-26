package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.PaisesService;

class TestPaisesService {
	static PaisesService service;
	@BeforeAll
	static void setUpBeforeClass() {
		service = new PaisesService();
	} 
	@Test
	void testListaContinentes() {
		assertEquals(7, service.listaContinente().size());
	}

	@Test
	void testListaPaisPorContinente() {
		assertEquals(50, service.listaPaises("Asia").size());
	}

	@Test
	void testPaisMasPoblado() {
		assertEquals("China", service.paisMasPoblado().get().getNombre());
	}

	/*@Test
	void testTablaPorContinente() {
		fail("Not yet implemented");
	}

	@Test
	void testTablaPaisesPorContinente() {
		fail("Not yet implemented");
	}*/

	@Test
	void testPaisPorCapital() {
		assertEquals("Afghanistan", service.getPaisFiltradoPor("Kabul"));
	} 

}
