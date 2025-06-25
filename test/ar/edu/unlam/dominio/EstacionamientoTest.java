package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.excepciones.IngresoNoEncontradoException;
import ar.edu.unlam.dominio.excepciones.VehiculoEstacionadoException;

public class EstacionamientoTest {

	private Estacionamiento estacionamiento;

	@Before
	public void init() {
		this.estacionamiento = new Estacionamiento();
		// Incluimos el reinicio para siempre empezar con id 1 en cada prueba
		Ingreso.reiniciarproximoIDIngreso();
	}

	@Test
	public void dadoQueExisteUnEstacionamientoRealizarUnIngresoDeUnAutomovilAlEstacionamiento() throws Exception {
		String patente = "ac111jj";
		Integer modelo = 2022;

		Vehiculo vehiculo = new Camioneta(patente, modelo);
		LocalDateTime entrada = LocalDateTime.of(2025, 06, 01, 9, 00);

		Boolean seRegistro = this.estacionamiento.ingresarVehiculo(vehiculo, entrada);
		assertTrue(seRegistro);

		Ingreso ingreso = this.estacionamiento.obtenerIngresoPorId(1);

		assertEquals(1, (int) ingreso.getId());

		assertEquals(vehiculo, ingreso.getVehiculo());

		assertNull(ingreso.getSalida());
	}

	@Test
	public void dadoQueExisteUnEstacionamientoConUnIngresoRealizarLaSalidaDelMismo()
			throws IngresoNoEncontradoException, VehiculoEstacionadoException {
		String patente = "ac111jj";
		Integer modelo = 2022;

		Vehiculo vehiculo = new Camioneta(patente, modelo);
		LocalDateTime entrada = LocalDateTime.of(2025, 06, 01, 9, 00);

		this.estacionamiento.ingresarVehiculo(vehiculo, entrada);

		// LocalDateTime salida=LocalDateTime.of(2025,06,01,10,00);

		this.estacionamiento.registraSalida(patente, 1);

		Ingreso ingreso = this.estacionamiento.obtenerIngresoPorId(1);

		assertNotNull(ingreso.getSalida());
		LocalDateTime horaEsperada = LocalDateTime.of(2025, 06, 01, 10, 00);
		assertEquals(horaEsperada, ingreso.getSalida());
	}

	@Test(expected = VehiculoEstacionadoException.class)
	public void dadoQueExisteUnEstacionamientoRealizar2IngresoDeUnMismoAutomovilyQueNoSeRegistroLaSalida()
			throws VehiculoEstacionadoException {
		
		String patente = "ac111jj";
		Integer modelo = 2022;
		Estacionamiento estacionamiento = new Estacionamiento();
		Vehiculo vehiculo = new Camioneta(patente, modelo);
		LocalDateTime entrada = LocalDateTime.of(2025, 06, 01, 9, 00);

		estacionamiento.ingresarVehiculo(vehiculo, entrada);
		estacionamiento.ingresarVehiculo(vehiculo, entrada);
		
//		try {
//			estacionamiento.ingresarVehiculo(vehiculo, entrada);
//			estacionamiento.ingresarVehiculo(vehiculo, entrada);
//			fail("El vehiculo no salio");
//		} catch (Exception e) {
//
//		}

		// El vehiculo no salio
	}

	@Test
	public void dadoQueExistenIngresosEnElEstacionamientoCuandoLosObtengoEstanOrdenadosDescendentementePorIdIngreso()
			throws VehiculoEstacionadoException {
		Vehiculo camioneta = new Camioneta("asd-123", 2020);
		this.estacionamiento.ingresarVehiculo(camioneta, LocalDateTime.of(2025, 06, 01, 9, 00));
		this.estacionamiento.registraSalida("asd-123", 1);

		this.estacionamiento.ingresarVehiculo(camioneta, LocalDateTime.of(2025, 06, 01, 12, 00));
		this.estacionamiento.registraSalida("asd-123", 1);

		this.estacionamiento.ingresarVehiculo(camioneta, LocalDateTime.of(2025, 06, 01, 15, 00));
		this.estacionamiento.registraSalida("asd-123", 1);

		Set<Ingreso> ingresos = this.estacionamiento.getIngresos();
		// Debe contener 3 registros de ingreso
		assertTrue(ingresos.size() == 3);

		int index = 0;

		// Verificamos que esten ordenados correctamente
		for (Ingreso ingreso : ingresos) {

			if (index == 0) {
				assertEquals(3, (int) ingreso.getId());
			}

			if (index == 1) {
				assertEquals(2, (int) ingreso.getId());
			}
			
			if (index == 2) {
				assertEquals(1, (int) ingreso.getId());
			}

			index++;
		}
	}

	@Test
	public void dadoQueExisteUnReporteConPatentesEIngresosCuandoLoObtengoLosIngresosDeCadaPatenteEstanOrdenadosDeManeraAscendente()
			throws VehiculoEstacionadoException {

		Vehiculo camioneta = new Camioneta("asd-123", 2020);
		Vehiculo auto = new Auto("qwe-123", 2022);

		this.estacionamiento.ingresarVehiculo(camioneta, LocalDateTime.of(2025, 06, 01, 9, 00));
		this.estacionamiento.registraSalida("asd-123", 1);

		this.estacionamiento.ingresarVehiculo(camioneta, LocalDateTime.of(2025, 06, 01, 12, 00));
		this.estacionamiento.registraSalida("asd-123", 1);

		this.estacionamiento.ingresarVehiculo(camioneta, LocalDateTime.of(2025, 06, 01, 15, 00));
		this.estacionamiento.registraSalida("asd-123", 1);

		this.estacionamiento.ingresarVehiculo(auto, LocalDateTime.of(2025, 06, 01, 9, 00));
		this.estacionamiento.registraSalida("qwe-123", 2);

		this.estacionamiento.ingresarVehiculo(auto, LocalDateTime.of(2025, 06, 01, 16, 00));
		this.estacionamiento.registraSalida("qwe-123", 2);

		this.estacionamiento.ingresarVehiculo(auto, LocalDateTime.of(2025, 06, 01, 20, 00));
		this.estacionamiento.registraSalida("qwe-123", 2);

		Map<String, Set<Ingreso>> reporte = this.estacionamiento.obtenerReporteDeVehiculos();

		// Debe contener las siguientes patentes
		assertTrue(reporte.containsKey("asd-123"));
		assertTrue(reporte.containsKey("qwe-123"));

		Set<Ingreso> ingresosDeCadaPatente = reporte.get("asd-123");
		// Debe contener 3 registros de ingreso
		assertTrue(ingresosDeCadaPatente.size() == 3);

		int index = 0;

		// Verificamos que esten ordenados correctamente
		for (Ingreso ingreso : ingresosDeCadaPatente) {

			if (index == 0) {
				assertEquals(1, (int) ingreso.getId());
			}

			if (index == 1) {
				assertEquals(2, (int) ingreso.getId());
			}
			
			if (index == 2) {
				assertEquals(3, (int) ingreso.getId());
			}

			index++;
		}

		ingresosDeCadaPatente = reporte.get("qwe-123");
		// Debe contener 3 registros de ingreso
		assertTrue(ingresosDeCadaPatente.size() == 3);

		index = 0;
		ingresosDeCadaPatente = reporte.get("qwe-123");

		// Verificamos que esten ordenados correctamente
		for (Ingreso ingreso : ingresosDeCadaPatente) {

			if (index == 0) {
				assertEquals(4, (int) ingreso.getId());
			}

			if (index == 1) {
				assertEquals(5, (int) ingreso.getId());
			}
			
			if (index == 2) {
				assertEquals(6, (int) ingreso.getId());
			}

			index++;
		}
	}

}
