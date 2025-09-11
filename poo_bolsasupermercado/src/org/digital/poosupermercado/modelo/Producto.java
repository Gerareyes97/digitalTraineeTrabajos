package org.digital.poosupermercado.modelo;

import org.digital.poosupermercado.modelo.persona.IProducto;
import org.digital.poosupermercado.repositorio.Identificable;

import java.util.Objects;

public class Producto implements IProducto, Identificable {

    protected Integer id;
    protected String nombre;
    protected Double precio;

    public Producto(Integer id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    @Override
    public double calcularImpuesto() {
        return precio * 0.12;
    }

    @Override
    public String descripcion() {
        return nombre + " - $" + precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
