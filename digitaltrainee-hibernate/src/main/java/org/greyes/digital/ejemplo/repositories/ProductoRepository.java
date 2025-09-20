package org.greyes.digital.ejemplo.repositories;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Producto;

import java.util.List;

public class ProductoRepository implements CrudRepository<Producto> {

    private final EntityManager em;

    public ProductoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Producto> listar() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) {
        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = porId(id);
        if (producto != null) {
            em.remove(producto);
        }
    }
}
