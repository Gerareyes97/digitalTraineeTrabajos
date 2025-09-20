package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar"));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrse el nombre", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrse el apellido", c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrse la forma de pago", c.getFormaPago());

            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.merge(c);
            em.getTransaction().commit();

            System.out.println(c);

        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
