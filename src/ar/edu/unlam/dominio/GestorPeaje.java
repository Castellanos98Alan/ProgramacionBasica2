package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class GestorPeaje {

	private HashSet <Pase> pases ;

	private ArrayList <Tarifa> tarifas; 
	

	public GestorPeaje() {
		this.pases = new HashSet<>();
		this.tarifas=new ArrayList<>();
	}
	
	public Boolean agregarPase(Pase pase) {
		// TODO Auto-generated method stub
 		return this.pases.add(pase);
	}

	public HashSet<Vehiculo> obtenerTodosLosVehiculos() {

		HashSet<Vehiculo> vehiculos = new HashSet<>();
		for (Pase pase : pases) {
			//if(!vehiculos.contains(pase.getVehiculo()))
		    	vehiculos.add(pase.getVehiculo());
		}
		
		return vehiculos;
	}
	
	public Double obtenerMontoAABonarDeUnVehiculoParaUnMesDado(String patente, int anio,int mes) {
	
		
		return null;
	}
	 

	public Tarifa obtenerTarifaVigente() {
		for (Tarifa tarifa : this.tarifas) {
			if (tarifa.getHasta() == null)
				return tarifa;
		}
		return null;
	}

}
