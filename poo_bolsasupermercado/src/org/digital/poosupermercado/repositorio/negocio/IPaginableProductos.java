package org.digital.poosupermercado.repositorio.negocio;

import java.util.List;

public interface IPaginableProductos <T>{
    List<T> listaPorCategoria(String categoria, int cantidad);
}
