package org.digital.poosupermercado.modelo;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T> {

    private List<T> productos;
    private int indiceProducts;

    public BolsaSupermercado() {
        this.productos = new ArrayList<>();
    }

    public List<T> getProductos() {
        return productos;
    }

    public BolsaSupermercado<T> addProductos(T producto){
        long count = productos.stream()
                .filter(p -> p.getClass().equals(producto.getClass()))
                .count();

        if (count >= 5) {
            throw new RuntimeException("No se pueden agregar más de 5 productos del tipo "
                    + producto.getClass().getSimpleName());
        }

        this.productos.add(producto);
        return this;
    }
}
