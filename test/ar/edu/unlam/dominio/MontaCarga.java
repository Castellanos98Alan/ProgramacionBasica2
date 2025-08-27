package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class MontaCarga {

	private Double pesoMaximoPermitido;

	private ArrayList<Carga> cargas = new ArrayList<>();
	public MontaCarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido=pesoMaximoPermitido;
		 
	}

	public Double getPesoMaximoPermitido() {
		// TODO Auto-generated method stub
		return this.pesoMaximoPermitido;
	}

	public void cargar(Carga carga) {
		
		this.cargas.add(carga);
	}

	public Integer obtenerCantidadDeCargas() {
		// TODO Auto-generated method stub
		return this.cargas.size();
	}

	public Double obtenerPesoCargado() {

		Double totalCargado= 0.0;
		for (Carga carga : this.cargas) {
			totalCargado +=  carga.getPeso();

    }
		
		return totalCargado;
		//	 	recorro
//	 	sumo
//	 	retorno total
	}

	public void vaciar() {

		this.cargas.clear();
		
	}

	//! 100   200             !!                            
}   
