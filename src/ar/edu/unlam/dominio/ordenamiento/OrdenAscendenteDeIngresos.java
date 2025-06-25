package ar.edu.unlam.dominio.ordenamiento;

import java.util.Comparator;

import ar.edu.unlam.dominio.Ingreso;

public class OrdenAscendenteDeIngresos implements Comparator<Ingreso>{

	@Override
	public int compare(Ingreso o1, Ingreso o2) {
		return o1.getId().compareTo(o2.getId());
	}
}
