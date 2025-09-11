package org.digital.poosupermercado.modelo;

public class NoPerecible extends Producto {

    private int contenido;
    private int calorias;

    public NoPerecible(Integer id, String nombre, Double precio, int contenido, int calorias) {
        super(id, nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public int getCalorias() {
        return calorias;
    }

}
