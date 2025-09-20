package org.greyes.digital.ejemplo.services;

import org.greyes.digital.ejemplo.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listar();
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);

}
