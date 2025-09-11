package org.digital.poosupermercado.repositorio;

import org.digital.poosupermercado.repositorio.excepciones.*;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractListRepositorio<T extends Identificable> implements ProductoRepositorioInterface<T> {

    protected List<T> datos;

    public AbstractListRepositorio() {
        this.datos = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return datos;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if (id == null || id <= 0){
            throw new LecturaAccesoDatoException("ID inválido, debe ser positivo");
        }
        T resultado = null;
        for (T t : datos) {
            if (t.getId() != null && t.getId().equals(id)) {
                resultado = t;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException, RegistroDuplicadoException, LecturaAccesoDatoException{
        if (t == null){
            throw new EscrituraAccesoDatoException("No se puede insertar un objeto nulo");
        }

        if (t.getId() == null || t.getId() <=0){
            throw new EscrituraAccesoDatoException("El objeto debe tener un ID válido");
        }

        boolean existe = datos.stream().anyMatch(p -> p.getId().equals(t.getId()) && p.getClass().equals(t.getClass()));
        if (existe){
            throw new RegistroDuplicadoException("Ya existe un registro con ID " + t.getId() + " y tipo: " + t.getClass().getSimpleName());
        }
        datos.add(t);
    }

    @Override
    public void editar(T t) throws EscrituraAccesoDatoException, LecturaAccesoDatoException{
        if (t == null){
            throw new EscrituraAccesoDatoException("No se puede insertar un objeto nulo");
        }
        T origen = porId(t.getId());
        if (origen != null){
            int index = datos.indexOf(origen);
            datos.set(index, t);
        }
    }

    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException{
        T origen = porId(id);
        if (origen == null) {
            throw new LecturaAccesoDatoException("No se puede eliminar. No existe registro con id: " + id);
        }
        datos.remove(origen);
    }

    //Metodos para todos los repositorios

    public List<T> listarPorCantidad(int cantidad) {
        cantidad = Math.min(cantidad, listar().size());
        return listar().subList(0, cantidad);
    }

    @Override
    public int total() {
        return datos.size();
    }

    @Override
    public List<T> listar(String campo, Direccion dir) throws SinDatosException {
        if (datos.isEmpty()){
            throw new SinDatosException("El repositorio está vacío, no se puede listar");
        }
        List<T> listaOrdenada = new ArrayList<>(this.datos);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });

        return listaOrdenada;
    }

    protected abstract int ordenar(String campo, T a, T b);

}
