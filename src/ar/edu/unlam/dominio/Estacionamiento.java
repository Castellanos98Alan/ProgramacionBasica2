package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Estacionamiento {

	private Set<Ingreso> ingresos;

	private Map<String, Double> tarifas;

	public Estacionamiento() {
		this.ingresos = new TreeSet<>();
		this.tarifas = new HashMap<>();
		this.tarifas.put("Camioneta", 150.0);
		this.tarifas.put("Auto", 100.0);

	}

	public Boolean ingresarVehiculo(Vehiculo vehiculo, LocalDateTime entrada) throws VehiculoEstacionadoException {

		
		verificoSiSeIngresoElVehiculoYAunNoSalio(vehiculo);
		Double precioHoraBase = 0.0;

		if (vehiculo instanceof Camioneta)
			precioHoraBase = this.tarifas.get("Camioneta");

		if (vehiculo instanceof Auto)
			precioHoraBase = this.tarifas.get("Auto");

//		precioHoraBase = this.tarifas.get(vehiculo.getClass().getSimpleName());

		// Integer id = this.ingresos.size()+1;
//		Ingreso ingreso = new Ingreso (vehiculo,entrada,precioHoraBase,id);
		Ingreso ingreso = new Ingreso(vehiculo, entrada, precioHoraBase);

		return this.ingresos.add(ingreso);

	}

	

	private void verificoSiSeIngresoElVehiculoYAunNoSalio(Vehiculo vehiculo) throws VehiculoEstacionadoException {
		for (Ingreso ingreso : ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(vehiculo.getPatente()))
				if(ingreso.getSalida()==null)
					throw new VehiculoEstacionadoException();
					
					
		}
	}

	public Ingreso obtenerIngresoPorId(Integer id) throws IngresoNoEncontradoException {
		for (Ingreso ingreso : ingresos) {
			if (ingreso.getId().equals(id))
				return ingreso;
		}

		throw new IngresoNoEncontradoException();
	}

	public void registraSalida(String patente, Integer cantidadHoras) {

		for (Ingreso ingreso : ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(patente) && ingreso.getSalida() == null) {

				ingreso.setSalida(ingreso.getEntrada().plusHours(cantidadHoras));
			}

		}

	}

	public void registraSalida(String patente, LocalDateTime salida) {

		for (Ingreso ingreso : ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(patente) && ingreso.getSalida() == null) {

				ingreso.setSalida(salida);
			}

		}

	}

}
