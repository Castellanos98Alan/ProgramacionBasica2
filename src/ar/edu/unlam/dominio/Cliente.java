package ar.edu.unlam.dominio;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;

    public Cliente(String dni, String nombre, String apellido, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getDni() { return dni; }

    @Override
    public String toString() {
        return "Cliente [DNI=" + dni + ", Nombre=" + nombre + " " + apellido + ", Tel=" + telefono + "]";
    }
}	
