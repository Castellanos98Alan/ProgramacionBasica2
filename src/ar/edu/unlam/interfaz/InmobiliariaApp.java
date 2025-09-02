package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.Propiedad;

public class InmobiliariaApp {

    private static ArrayList<Propiedad> propiedades = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
       

        do {
            opcion = mostrarMenu(teclado);
            switch (opcion) {
                case 1: agregarPropiedad(teclado);
                break;
                case 2: modificarPropiedad(teclado);
                break;
                case 3 : agregarCliente(teclado);
                break;
                case 4 : buscarPropiedades(teclado);
                break;
                case 5 : realizarVenta(teclado);
                break;
                case 0 : System.out.println("Saliendo del sistema...");
                break;
                default : System.out.println("Opción inválida.");
                break;
            }
        } while (opcion != 0);

        teclado.close();
    }

    private static int mostrarMenu(Scanner sc) {
        System.out.println("\n===== MENÚ INMOBILIARIA =====");
        System.out.println("1. Agregar nueva propiedad");
        System.out.println("2. Modificar propiedad existente");
        System.out.println("3. Agregar cliente");
        System.out.println("4. Buscar propiedades");
        System.out.println("5. Realizar venta de una propiedad");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
        return sc.nextInt();
    }

    // 1. Agregar Propiedad
    private static void agregarPropiedad(Scanner sc) {
        System.out.print("Código: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = sc.nextLine();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();
        System.out.print("Vendedor: ");
        String vendedor = sc.nextLine();

        propiedades.add(new Propiedad(codigo, direccion, ciudad, precio, vendedor));
        System.out.println("✅ Propiedad agregada con éxito.");
    }

    // 2. Modificar propiedad
    private static void modificarPropiedad(Scanner sc) {
        System.out.print("Ingrese código de propiedad a modificar: ");
        int codigo = sc.nextInt();
        for (Propiedad p : propiedades) {
            if (p.getCodigo() == codigo) {
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = sc.nextDouble();
                p.setPrecio(nuevoPrecio);
                System.out.println("✅ Propiedad modificada.");
                return;
            }
        }
        System.out.println("❌ No se encontró la propiedad con código " + codigo);
    }

    // 3. Agregar Cliente (validando DNI único)
    private static void agregarCliente(Scanner sc) {
        sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                System.out.println("❌ Ya existe un cliente con ese DNI.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        clientes.add(new Cliente(dni, nombre, apellido, telefono));
        System.out.println("✅ Cliente agregado con éxito.");
    }

    // 4. Buscar propiedades
    private static void buscarPropiedades(Scanner sc) {
        System.out.println("a) Buscar por rango de precios");
        System.out.println("b) Buscar por ciudad");
        System.out.print("Elige opción: ");
        char subopcion = sc.next().toLowerCase().charAt(0);

        switch (subopcion) {
            case 'a' : {
                System.out.print("Precio mínimo: ");
                double min = sc.nextDouble();
                System.out.print("Precio máximo: ");
                double max = sc.nextDouble();
                for (Propiedad p : propiedades) {
                    if (p.getPrecio() >= min && p.getPrecio() <= max) {
                        System.out.println(p);
                    }
                }
            }
            case 'b' : {
                sc.nextLine();
                System.out.print("Ciudad: ");
                String ciudad = sc.nextLine();
                for (Propiedad p : propiedades) {
                    if (p.getCiudad().equalsIgnoreCase(ciudad)) {
                        System.out.println(p);
                    }
                }
            }
            default : System.out.println("❌ Opción inválida.");
        }
    }

    // 5. Realizar venta
    private static void realizarVenta(Scanner sc) {
        System.out.print("Ingrese código de la propiedad a vender: ");
        int codigo = sc.nextInt();

        for (Propiedad p : propiedades) {
            if (p.getCodigo() == codigo) {
                propiedades.remove(p);
                System.out.println("✅ Propiedad vendida con éxito.");
                return;
            }
        }
        System.out.println("❌ No se encontró la propiedad.");
    }
}

