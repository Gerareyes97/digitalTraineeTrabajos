package org.digital.poosupermercado.repositorio.negocio;

import java.util.List;

public interface IPaginableVendedores<T>{
    List<T> listaPorSalario(double minSalario, double maxSalario,  int cantidad);
}
