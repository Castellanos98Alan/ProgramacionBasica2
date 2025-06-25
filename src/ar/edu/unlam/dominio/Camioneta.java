package ar.edu.unlam.dominio;

import java.util.Objects;

public class Camioneta implements Vehiculo {

	private String patente;
	private Integer modelo;

	public Camioneta(String patente, Integer modelo) {
		this.patente=patente;
		this.modelo=modelo;
				
	}

	@Override
	public String getPatente() {
		// TODO Auto-generated method stub
		return this.patente;
	}

	@Override
	public Double obtenerPorcentajeDescuento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camioneta other = (Camioneta) obj;
		return Objects.equals(patente, other.patente);
	}
	
	

}
