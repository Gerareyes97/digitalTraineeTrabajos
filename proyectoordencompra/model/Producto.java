package org.proyectoordencompra.model;

public class Producto {

    private String fabricante;
    private String nombre;
    private int precio;

    public Producto(String fabricante, String nombre, int precio) {
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "\nProducto: " +
                "\nFabricante: " + this.getFabricante() +
                "\nNombre: " + this.getNombre() +
                "\nPrecio: " + this.getPrecio();
    }
}
