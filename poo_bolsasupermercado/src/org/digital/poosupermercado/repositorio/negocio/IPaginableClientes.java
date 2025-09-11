package org.digital.poosupermercado.repositorio.negocio;

import java.util.List;

public interface IPaginableClientes<T>{
    List<T> listaPorPuntos(int minPuntos, int maxPuntos,  int cantidad);
}
