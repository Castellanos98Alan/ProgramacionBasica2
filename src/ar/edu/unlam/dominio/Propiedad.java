package ar.edu.unlam.dominio;

public class Propiedad {
    private int codigo;
    private String direccion;
    private String ciudad;
    private double precio;
    private String vendedor;

    public Propiedad(int codigo, String direccion, String ciudad, double precio, String vendedor) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.precio = precio;
        this.vendedor = vendedor;
    }

    public int getCodigo() { return codigo; }
    public String getCiudad() { return ciudad; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Propiedad [Código=" + codigo + ", Dirección=" + direccion + ", Ciudad=" + ciudad +
               ", Precio=" + precio + ", Vendedor=" + vendedor + "]";
    }
}	