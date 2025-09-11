package org.digital.poosupermercado.repositorio.lista;

import org.digital.poosupermercado.modelo.Producto;
import org.digital.poosupermercado.repositorio.*;
import org.digital.poosupermercado.repositorio.excepciones.SinDatosException;
import org.digital.poosupermercado.repositorio.negocio.IPaginableProductos;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoRepositorio extends AbstractListRepositorio<Producto> implements IPaginableProductos<Producto> {

    @Override
    public List<Producto> listaPorCategoria(String categoria, int cantidad) {
        return datos.stream()
                .filter(p -> p.getClass().getSimpleName().equalsIgnoreCase(categoria))
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    @Override
    public int total() {
        return datos.size();
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) throws SinDatosException {
        return super.listar(campo, dir);
    }

    @Override
    protected int ordenar(String campo, Producto a, Producto b) {
        return switch (campo.toLowerCase()) {
            case "nombre" -> a.getNombre().compareToIgnoreCase(b.getNombre());
            case "precio" -> Double.compare(a.getPrecio(), b.getPrecio());
            default -> 0;
        };
    }

    @Override
    public List<Producto> listarPorCantidad(int cantidad) {
        return super.listarPorCantidad(cantidad);
    }
}
