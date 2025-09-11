package org.digital.poosupermercado.modelo;

import org.digital.poosupermercado.repositorio.Identificable;

public class Lacteo extends Producto implements Identificable {

    private int cantidad;
    private int proteinas;

    public Lacteo(Integer id, String nombre, Double precio, int cantidad, int proteinas) {
        super(id, nombre, precio);
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getProteinas() {
        return proteinas;
    }

}
