package org.digital.poosupermercado.repositorio;

import org.digital.poosupermercado.repositorio.excepciones.SinDatosException;

import java.util.List;

public interface OrdenableRepositorio<T> {

    List<T> listar(String campo, Direccion dir) throws SinDatosException;
}
