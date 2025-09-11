package org.digital.poosupermercado.repositorio;

import org.digital.poosupermercado.repositorio.negocio.IPaginableProductos;

public interface ProductoRepositorioInterface<T> extends
        PaginableRepositorio<T>, OrdenableRepositorio<T>, ICrudRepositorio<T>,
        IContableRepositorio, IPaginableProductos<T> {
}
