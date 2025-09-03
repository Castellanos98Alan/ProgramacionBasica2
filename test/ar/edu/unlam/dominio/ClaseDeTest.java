package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class ClaseDeTest {
	
	@Test
		public void dadoQueExisteUnGestorDePeajeAlRegistrarUnPaseObtengoUnresultadoExitoso() {
			
			GestorPeaje telepase = new GestorPeaje();
			
			
			String patente="ac111as";
			String marco = "fiat";
			String modelo = "punto";
			Vehiculo vehiculo = new Vehiculo (patente,marco,modelo);
			LocalDateTime fechayHora = LocalDateTime.of(2025, 9,03,12,0);
			Pase pase = new Pase(vehiculo ,fechayHora );
			Boolean seAgrego=telepase.agregarPase(pase);
			assertTrue(seAgrego);
			
			
			
		}
	
	
	@Test
	public void dadoQueExisteUnGestorDePeajeAlRegistrarUnPaseIgualesNoMergistraEl2doPase() {
		
		GestorPeaje telepase = new GestorPeaje();
		
		
		String patente="ac111as";
		String marco = "fiat";
		String modelo = "punto";
		Vehiculo vehiculo = new Vehiculo (patente,marco,modelo);
		LocalDateTime fechayHora = LocalDateTime.of(2025, 9,03,12,0);
		Pase pase = new Pase(vehiculo ,fechayHora );
		Boolean seAgrego=telepase.agregarPase(pase);
		assertTrue(seAgrego);

		Vehiculo vehiculo2 = new Vehiculo (patente,marco,"qubo");
		Pase pase2 = new Pase(vehiculo2 ,fechayHora );
		
		Boolean noSeAgrego=telepase.agregarPase(pase2);
		assertFalse(noSeAgrego);
		
	}

	@Test
	public void dadoQueExisteUnGestorDePeajeAlRegistrar2PasesDeunVehiculoYotroPaseDeotroVheculoObtengoUnListadoConLos2Vehiculos() {
		
		GestorPeaje telepase = new GestorPeaje();
		
		
		String patente="ac111as";
		String marco = "fiat";
		String modelo = "punto";
		
		
		
		Vehiculo vehiculo = new Vehiculo (patente,marco,modelo);
		LocalDateTime fechayHora = LocalDateTime.of(2025, 9,03,12,0);
		Pase pase = new Pase(vehiculo ,fechayHora );
		Boolean seAgrego=telepase.agregarPase(pase);
 
		
		String patente2="ac333fr";
		String marco2 = "fiat";
		String modelo2 = "punto";

		LocalDateTime fechayHora2 = LocalDateTime.of(2025, 9,03,13,0);
		Vehiculo vehiculo2 = new Vehiculo (patente2,marco2,modelo2);
		Pase pase2 = new Pase(vehiculo2 ,fechayHora2 );
		telepase.agregarPase(pase2);
 
		LocalDateTime fechayHora3 = LocalDateTime.of(2025, 9,03,14,0);
		Pase pase3 = new Pase(vehiculo ,fechayHora3 );
		telepase.agregarPase(pase3);
 
		HashSet <Vehiculo> vehiculos  = telepase.obtenerTodosLosVehiculos();
		
		Integer valorEsperado = 2;
		Integer valorObtenido = vehiculos.size();
		assertEquals(valorEsperado,valorObtenido);
		
	}

	

}
