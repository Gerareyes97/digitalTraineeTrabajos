package org.digital.poosupermercado.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {

    List<T> listarPorCantidad(int cantidad);
}
