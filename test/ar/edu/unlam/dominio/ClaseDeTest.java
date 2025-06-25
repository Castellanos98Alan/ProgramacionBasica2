package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

public class ClaseDeTest {

	@Test
	public void dadoQueExisteUnEstacionamientoRealizarUnIngresoDeUnAutomovilAlEstacionamiento() throws Exception {
		String patente = "ac111jj";
		Integer modelo=2022;
		Estacionamiento estacionamiento = new Estacionamiento ();
		Vehiculo vehiculo = new Camioneta (patente,modelo);
		LocalDateTime entrada=LocalDateTime.of(2025,06,01,9,00);
		
		Boolean seRegistro = estacionamiento.ingresarVehiculo(vehiculo,entrada);
		assertTrue(seRegistro);
				
		Ingreso ingreso = estacionamiento.obtenerIngresoPorId(1);
		
		
		assertEquals(1,ingreso.getId(),0.00);
	
		assertEquals(vehiculo,ingreso.getVehiculo());
		
		assertNull(ingreso.getSalida());
		
		
	}
	
	
	@Test
	public void dadoQueExisteUnEstacionamientoConUnIngresoRealizarLaSalidaDelMismo() throws IngresoNoEncontradoException, VehiculoEstacionadoException {
		String patente = "ac111jj";
		Integer modelo=2022;
		Estacionamiento estacionamiento = new Estacionamiento ();
		Vehiculo vehiculo = new Camioneta (patente,modelo);
		LocalDateTime entrada=LocalDateTime.of(2025,06,01,9,00);
		
		estacionamiento.ingresarVehiculo(vehiculo,entrada);
		
		//LocalDateTime salida=LocalDateTime.of(2025,06,01,10,00);
		
		estacionamiento.registraSalida(patente,1);
		
		
		Ingreso ingreso = estacionamiento.obtenerIngresoPorId(1);
		
		
	 
		assertNotNull(ingreso.getSalida());
		
		LocalDateTime horaEsperada = LocalDateTime.of(2025,06,01,10,00);
		assertEquals(horaEsperada, ingreso.getSalida());
		
			
	}
	


	@Test(expected = VehiculoEstacionadoException.class)
	public void dadoQueExisteUnEstacionamientoRealizar2IngresoDeUnMismoAutomovilyQueNoSeRegistroLaSalida() throws VehiculoEstacionadoException {
		String patente = "ac111jj";
		Integer modelo=2022;
		Estacionamiento estacionamiento = new Estacionamiento ();
		Vehiculo vehiculo = new Camioneta (patente,modelo);
		LocalDateTime entrada=LocalDateTime.of(2025,06,01,9,00);
		
	   estacionamiento.ingresarVehiculo(vehiculo,entrada);
	   estacionamiento.ingresarVehiculo(vehiculo,entrada);
		
		
	}
	

	
	
	
}
