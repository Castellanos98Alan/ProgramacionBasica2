package ar.edu.unlam.dominio;

import java.time.LocalDateTime;

public class Ingreso implements Comparable<Ingreso> {

	private static Integer proximoIDIngreso = 1;
	private Integer id;
	private Vehiculo vehiculo;
	private LocalDateTime entrada;
	private LocalDateTime salida;
	private Double precioHoraBase;

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

	/**
	 * Vuelve a asignar el id 1 al contador para usar en las pruebas
	 */
	public static void reiniciarproximoIDIngreso() {
		proximoIDIngreso = 1;
	}

	@Override
	public int compareTo(Ingreso ingreso) {

		return ingreso.getId().compareTo(this.id);
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
		return this.salida;
	}

	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}
}
