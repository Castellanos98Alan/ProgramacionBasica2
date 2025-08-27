package ar.edu.unlam.dominio;

import java.util.Objects;

public class Carga {

	private Long id;
	private Double peso;

	public Carga(Double peso) {
		this.peso = peso;
	}

	public Carga(Long id, Double peso) {
		this.id = id;
		this.peso = peso;
	}

	public Double getPeso() {

		return this.peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, peso);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true; // Si es el mismo objeto o instancia

		if (obj == null)
			return false; // Comprueba que exista el parametro

		if (getClass() != obj.getClass())
			return false; // Comprueba que sean de la misma clase

		Carga other = (Carga) obj;

		return this.id.equals(other.id) && this.peso.equals(other.peso);

		// return Objects.equals(id, other.id) && Objects.equals(peso, other.peso);
	}

}
