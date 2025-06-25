package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ar.edu.unlam.dominio.excepciones.IngresoNoEncontradoException;
import ar.edu.unlam.dominio.excepciones.VehiculoEstacionadoException;
import ar.edu.unlam.dominio.ordenamiento.OrdenAscendenteDeIngresos;

public class Estacionamiento {

	private Set<Ingreso> ingresos;
	private Map<String, Double> tarifas;

	public Estacionamiento() {
		this.ingresos = new TreeSet<>();
		this.tarifas = new HashMap<>();
		this.tarifas.put("Camioneta", 150.0);
		this.tarifas.put("Auto", 100.0);
	}
	
	public Set<Ingreso> getIngresos() {
		return this.ingresos;
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
		for (Ingreso ingreso : this.ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(vehiculo.getPatente()))
				if (ingreso.getSalida() == null)
					throw new VehiculoEstacionadoException("El vehiculo no salio");

		}
	}

	public Ingreso obtenerIngresoPorId(Integer id) throws IngresoNoEncontradoException {
		for (Ingreso ingreso : this.ingresos) {
			if (ingreso.getId().equals(id))
				return ingreso;
		}

		throw new IngresoNoEncontradoException();
	}

	public void registraSalida(String patente, Integer cantidadHoras) {

		for (Ingreso ingreso : this.ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(patente) && ingreso.getSalida() == null) {

				ingreso.setSalida(ingreso.getEntrada().plusHours(cantidadHoras));
			}
		}
	}

	public void registraSalida(String patente, LocalDateTime salida) {

		for (Ingreso ingreso : this.ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(patente) && ingreso.getSalida() == null) {

				ingreso.setSalida(salida);
			}
		}
	}

	public Set<Ingreso> obtenerIngresosPorPatente(String patente) {

		Set<Ingreso> ingresosDeLaPatente = new TreeSet<Ingreso>(new OrdenAscendenteDeIngresos());

		for (Ingreso ingreso : this.ingresos) {
			if (ingreso.getVehiculo().getPatente().equals(patente)) {
				ingresosDeLaPatente.add(ingreso);
			}
		}

		return ingresosDeLaPatente;
	}

	public Map<String, Set<Ingreso>> obtenerReporteDeVehiculos() {

		Map<String, Set<Ingreso>> mapa = new HashMap<String, Set<Ingreso>>();
		String patente = "";

		for (Ingreso ingreso : this.ingresos) {
			patente = ingreso.getVehiculo().getPatente();

			if (!mapa.containsKey(patente)) {
				mapa.put(patente, this.obtenerIngresosPorPatente(patente));
			}
		}

		return mapa;
	}

	/**
	 * Metodo con ejemplos para iterar map
	 * */
	public void pruebasIteracion() {

		// Map de ejemplo
		Map<String, Set<Ingreso>> mapa = new HashMap<String, Set<Ingreso>>();
		
		mapa.keySet(); // Obtiene todas la claves
		Collection<Set<Ingreso>> ingresos = mapa.values(); // obtiene todos los valores

		// Iterar el mapa con Entry
		for (Map.Entry<String, Set<Ingreso>> registro : mapa.entrySet()) {

			registro.getKey(); // obtiene la clave del registro actual
			registro.getValue(); // obtiene el/los valores del registro actual

		}

		Set<Ingreso> ingresosDeLaPatente = mapa.get("");

		// Para iterar sobre todas las claves
		for (String patente : mapa.keySet()) {

			mapa.get(patente);

		}

		// Iterar con la clase Iterator
		Iterator<String> iterador = mapa.keySet().iterator();

		// Mientras exista un registro siguiente hacemos algo
		while (iterador.hasNext()) {
			// Con .next() obtenemos el registro
			String patente = (String) iterador.next();
		}

	}

}
