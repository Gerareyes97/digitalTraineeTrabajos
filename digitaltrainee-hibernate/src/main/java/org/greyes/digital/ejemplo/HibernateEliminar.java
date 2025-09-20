package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.util.JpaUtil;

import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el  id del cliente a eliminar");
        Long id = sc.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }

    }
}
