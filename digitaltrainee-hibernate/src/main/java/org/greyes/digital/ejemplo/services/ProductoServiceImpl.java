package org.greyes.digital.ejemplo.services;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Producto;
import org.greyes.digital.ejemplo.repositories.CrudRepository;
import org.greyes.digital.ejemplo.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{

    private EntityManager em;
    private CrudRepository<Producto> repository;

    public ProductoServiceImpl(EntityManager em) {
        this.em = em;
        this.repository = new ProductoRepository(em);
    }

    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Producto producto) {
        try {
            em.getTransaction().begin();
            repository.guardar(producto);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try {

            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
