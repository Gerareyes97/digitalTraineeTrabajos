package org.digital.poosupermercado.repositorio;

import org.digital.poosupermercado.repositorio.excepciones.*;

import java.util.List;

public interface ICrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T t) throws AccesoDatoException;
    void editar(T t) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;
}
