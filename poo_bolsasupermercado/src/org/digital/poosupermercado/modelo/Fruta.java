package org.digital.poosupermercado.modelo;

import org.digital.poosupermercado.repositorio.Identificable;

public class Fruta extends Producto implements Identificable {

    private double peso;
    private String color;

    public Fruta(Integer id, String nombre, Double precio, double peso, String color) {
        super(id, nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public String getColor() {
        return color;
    }

}
