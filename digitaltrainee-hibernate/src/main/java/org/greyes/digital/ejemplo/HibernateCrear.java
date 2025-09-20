package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.util.JpaUtil;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            String nombre = JOptionPane.showInputDialog("Ingrse el nombre");
            String apellido = JOptionPane.showInputDialog("Ingrse el apellido");
            String pago = JOptionPane.showInputDialog("Ingrse la forma de pago");

            em.getTransaction().begin();
            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.persist(c);
            em.getTransaction().commit();

            System.out.println("El id cliente registrado es: " + c.getId());
            c = em.find(Cliente.class, c.getId());
            System.out.println(c);

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
