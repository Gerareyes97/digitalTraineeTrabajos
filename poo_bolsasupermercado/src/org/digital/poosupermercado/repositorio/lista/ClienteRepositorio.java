package org.digital.poosupermercado.repositorio.lista;

import org.digital.poosupermercado.modelo.persona.Cliente;
import org.digital.poosupermercado.repositorio.*;
import org.digital.poosupermercado.repositorio.excepciones.SinDatosException;
import org.digital.poosupermercado.repositorio.negocio.IPaginableClientes;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepositorio extends AbstractListRepositorio<Cliente> implements IPaginableClientes<Cliente> {

    @Override
    public List<Cliente> listaPorPuntos(int minPuntos, int maxPuntos, int cantidad) {
        return datos.stream()
                .filter(c -> c.getPuntos() >= minPuntos && c.getPuntos() <= maxPuntos)
                .limit(cantidad)
                .collect(Collectors.toList());
    }

    @Override
    public int total() {
        return datos.size();
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) throws SinDatosException {
        return super.listar(campo, dir);
    }

    @Override
    protected int ordenar(String campo, Cliente a, Cliente b) {
        return switch (campo.toLowerCase()) {
            case "nombre" -> a.getNombre().compareToIgnoreCase(b.getNombre());
            case "puntos" -> Integer.compare(a.getPuntos(), b.getPuntos());
            case "email" -> a.getEmail().compareToIgnoreCase(b.getEmail());
            case "id" -> Integer.compare(a.getId(), b.getId());
            default -> 0;
        };
    }

    @Override
    public List<Cliente> listarPorCantidad(int cantidad) {
        return super.listarPorCantidad(cantidad);
    }

    @Override
    public List<Cliente> listaPorCategoria(String categoria, int cantidad) {
        return List.of();
    }
}
