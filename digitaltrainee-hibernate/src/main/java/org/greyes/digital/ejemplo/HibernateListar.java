package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.util.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
