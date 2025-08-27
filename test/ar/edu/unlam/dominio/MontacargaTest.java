package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MontacargaTest {


	@Test
	public void dadoQueNoExisteUnaCargaAlCrearlaMismaSePuedeObtenerSuPeso() {
		
		Double peso = 100.0;
		Carga carga = new Carga (peso);
		Double valorEsperado = 100.0;
		Double valorObtenido = carga.getPeso();
		assertEquals(valorEsperado,valorObtenido);
		

	}

	
	@Test
	public void dadoQueNoExisteUnMontaCargaAlCrearlaMismaSePuedeObtenerSuPesoMaximoPermitido() {
		
		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga (pesoMaximoPermitido);
		Double valorEsperado = 1000.0;
		Double valorObtenido = montaCarga.getPesoMaximoPermitido();
		assertEquals(valorEsperado,valorObtenido);
		
	}
	

	@Test
	public void dadoQueExisteUnMontaCargaVerifiarqueSePuedaSubirUnaCarga() {
		
		
		Double peso = 100.0;
		Carga carga = new Carga (peso);
		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga (pesoMaximoPermitido);
		
		montaCarga.cargar(carga);
		Integer valorEsperado = 1;
		Integer valorObtenido = montaCarga.obtenerCantidadDeCargas();
		assertEquals(valorEsperado,valorObtenido);	
		
		
		
		
		
	}
	
	
	@Test
	public void dadoQueExisteUnMontaCargaYUnaCargaCuandoSuboLaCargaALmismoVerificarElpesoCargado() {
		
		
		Double peso = 100.0;
		Carga carga = new Carga (peso);
		Carga carga2 = new Carga (200.0);
		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga (pesoMaximoPermitido);
		
		montaCarga.cargar(carga);
		

		montaCarga.cargar(carga2);
		Double valorEsperado = 300.0;
		Double valorObtenido = montaCarga.obtenerPesoCargado();
		assertEquals(valorEsperado,valorObtenido);	
		
		
		
		
		
	}
	
	
	@Test
	public void dadoQueExisteUnMontaCargaConVariasCargasAlvaciarlObtengoCOmoPesoCargadoIgualACero() {
		
		
		Double peso = 100.0;
		Carga carga = new Carga (peso);
		Carga carga2 = new Carga (200.0);
		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga (pesoMaximoPermitido);
		
		montaCarga.cargar(carga);
		montaCarga.cargar(carga2);

		montaCarga.vaciar();
		
		
		Double valorEsperado = 0.0;
		Double valorObtenido = montaCarga.obtenerPesoCargado();
		assertEquals(valorEsperado,valorObtenido);	
		

		Integer valorEsperado2 = 0;
		
		Integer  valorObtenido2 = montaCarga.obtenerCantidadDeCargas();
		assertEquals(valorEsperado2,valorObtenido2);	
		
		
		
		
	}

}
