package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class MontaCarga {

	private Double pesoMaximoPermitido;

	private ArrayList<Carga> cargas = new ArrayList<>();

	private HashSet<Carga> cargasSinDuplicados;

	public MontaCarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
		this.cargasSinDuplicados = new HashSet<>();
	}

	public Double getPesoMaximoPermitido() {
		// TODO Auto-generated method stub
		return this.pesoMaximoPermitido;
	}

	public void cargar(Carga carga) {

		this.cargas.add(carga);
	}

	public boolean agregarCarga(Carga carga) {
		boolean agregada = this.cargasSinDuplicados.add(carga);
		return agregada;
	}

	public Integer obtenerCantidadDeCargas() {
		// TODO Auto-generated method stub
		return this.cargas.size();
	}

	public boolean existe(Carga cargaABuscar) {
		// Este metodo no tiene pruebas, es para mostrar como comparar con equals en
		// lugar de accerer al ID del objeto en la coleccion
		
		return this.cargas.contains(cargaABuscar);

		// Carga1
		// Carga2
		// Carga3

//		for (Carga carga : this.cargas) {
//
//			if (carga.equals(cargaABuscar)) {
//				return true;
//			}
//
//		}
//		return false;

//		for (int i = 0; i < array.length; i++) {
//			
//			if(array[i] != null && array[i].getId() == id) {
//				
//			}
//		}
	}

	public Double obtenerPesoCargado() {

		Double totalCargado = 0.0;
		for (Carga carga : this.cargas) {
			totalCargado += carga.getPeso();

		}

		return totalCargado;
		// recorro
//	 	sumo
//	 	retorno total
	}

	public void vaciar() {

		this.cargas.clear();

	}

	// ! 100 200 !!
}
