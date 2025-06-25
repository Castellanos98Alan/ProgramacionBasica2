package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Ingreso implements Comparable<Ingreso> {

	private static Integer proximoIDIngreso = 1;
	private Vehiculo vehiculo;
	private Integer id;
	private LocalDateTime entrada;
	private Double precioHoraBase;
	private LocalDateTime salida;

	public Ingreso(Vehiculo vehiculo, LocalDateTime entrada, Double precioHoraBase) {

		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.precioHoraBase = precioHoraBase;
		this.id = proximoIDIngreso++;
	}

	public Ingreso(Vehiculo vehiculo, LocalDateTime entrada, Double precioHoraBase, Integer id) {

		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.precioHoraBase = precioHoraBase;
		this.id = id;
	}

	@Override
	public int compareTo(Ingreso o) {
		 
		return  0;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public Double getPrecioHoraBase() {
		return precioHoraBase;
	}

	public void setPrecioHoraBase(Double precioHoraBase) {
		this.precioHoraBase = precioHoraBase;
	}

	public LocalDateTime getSalida() {
		// TODOa Auto-generated method stub
		return this.salida;
	}

	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}

	
	
}
