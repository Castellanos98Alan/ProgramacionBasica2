package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pase {

	private Vehiculo vehiculo;
	private LocalDateTime fechayHora;

	public Pase(Vehiculo vehiculo, LocalDateTime fechayHora) {
		this.vehiculo = vehiculo;
		this.fechayHora = fechayHora;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public LocalDateTime getFechayHora() {
		return fechayHora;
	}

	public void setFechayHora(LocalDateTime fechayHora) {
		this.fechayHora = fechayHora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechayHora, vehiculo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pase other = (Pase) obj;
		return Objects.equals(fechayHora, other.fechayHora) && Objects.equals(vehiculo, other.vehiculo);
	}
	
	
	
	

}
