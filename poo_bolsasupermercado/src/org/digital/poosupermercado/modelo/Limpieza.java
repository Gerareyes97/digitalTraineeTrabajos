package org.digital.poosupermercado.modelo;

public class Limpieza extends Producto {

    private String componentes;
    private double litros;

    public Limpieza(Integer id, String nombre, Double precio, String componentes, double litros) {
        super(id, nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }

    public String getComponentes() {
        return componentes;
    }

    public double getLitros() {
        return litros;
    }

}
