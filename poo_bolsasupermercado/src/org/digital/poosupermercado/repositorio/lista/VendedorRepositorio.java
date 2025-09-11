package org.digital.poosupermercado.repositorio.lista;

import org.digital.poosupermercado.modelo.persona.Vendedor;
import org.digital.poosupermercado.repositorio.*;
import org.digital.poosupermercado.repositorio.excepciones.SinDatosException;
import org.digital.poosupermercado.repositorio.negocio.IPaginableVendedores;

import java.util.List;
import java.util.stream.Collectors;

public class VendedorRepositorio extends AbstractListRepositorio<Vendedor>
implements IPaginableVendedores<Vendedor> {

    @Override
    public List<Vendedor> listaPorSalario(double minSalario, double maxSalario, int cantidad) {
        return datos.stream()
                .filter(v -> v.getSalario() >= minSalario && v.getSalario() <= maxSalario)
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    @Override
    public int total() {
        return datos.size();
    }

    @Override
    public List<Vendedor> listaPorCategoria(String categoria, int cantidad) {
        return List.of();
    }

    @Override
    public List<Vendedor> listar(String campo, Direccion dir) throws SinDatosException {
        return super.listar(campo, dir);
    }

    @Override
    protected int ordenar(String campo, Vendedor a, Vendedor b) {
        return switch (campo.toLowerCase()) {
            case "nombre" -> a.getNombre().compareToIgnoreCase(b.getNombre());
            case "salario" -> Double.compare(a.getSalario(), b.getSalario());
            default -> 0;
        };
    }

    @Override
    public List<Vendedor> listarPorCantidad(int cantidad) {
        return List.of();
    }
}
