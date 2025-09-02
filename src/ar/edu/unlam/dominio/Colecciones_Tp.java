package ar.edu.unlam.dominio;

import java.util.Scanner;

public class Colecciones_Tp {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
//		1.	Agregar nuevas propiedades (Las propiedades se pueden repetir, porque distintos vendedores pueden cargar una misma propiedad con diferentes valores de venta por ejemplo)
//		2.	 Modificar propiedades existentes (La búsqueda de propiedad se realiza por código)
//		3.	Agregar clientes (Son aquellos que se encuentran en búsqueda de una propiedad. No se puede agregar dos clientes con un mismo DNI)
//		4.	Buscar propiedades por diferentes parámetros:
//		a.	Rango de precios
//		b.	Ubicación (Ciudad)
//		5.	Realizar la venta de una propiedad
//
//		
		// Interger option2;
		int option;

		do {
			
			 option = mostrarMenu(teclado);
		
		


		switch (option) {
		case 1:

			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			System.out.println("Salir del sistema");
			break;

		default:
			System.out.println("Opcion incorrecta, reintentelo");
			break;
		}
		} while (option != 6);

		
		teclado.close();
	}
	
	
	public static int mostrarMenu(Scanner teclado) {
		
		System.out.println("1. Agregar nuevas propiedades");
		System.out.println("2. Modificar propiedades existentes");
		System.out.println("3. Agregar clientes");
		System.out.println("4. Buscar propiedades por diferentes parámetros:");
		System.out.println("5. Realizar la venta de una propiedad");
		System.out.println("6. SALIR");
		
		return teclado.nextInt();
				
	}
	
	

}
