package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.util.JpaUtil;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el id:");
        Long id = sc.nextLong();

        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, id);
        System.out.println(cliente2);

        em.close();
    }
}
