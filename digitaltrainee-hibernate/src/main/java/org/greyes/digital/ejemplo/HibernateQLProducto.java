package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.entity.Producto;
import org.greyes.digital.ejemplo.util.JpaUtil;

import java.util.List;

public class HibernateQLProducto {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        System.out.println("=== Listar todos los clientes ===");
        List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=== Listar todos los productos ===");
        List<Producto> productos = em.createQuery("select p from Producto p", Producto.class).getResultList();
        productos.forEach(System.out::println);

        System.out.println("=== Consulta por ID ===");
        Producto productoPorId = em.createQuery("select p from Producto p where p.id=:id", Producto.class)
                .setParameter("id", 2L)
                .getSingleResult();
        System.out.println(productoPorId);

        System.out.println("=== Consulta nombres de clientes y nombres de productos ===");
        List<Object[]> nombres = em.createQuery(
                        "select c.nombre, p.nombre from Cliente c, Producto p", Object[].class)
                .getResultList();
        nombres.forEach(arr -> System.out.println("Cliente=" + arr[0] + ", Producto=" + arr[1]));

        System.out.println("=== Consulta productos con precio mayor a 100 ===");
        productos = em.createQuery("select p from Producto p where p.precio > 100", Producto.class)
                .getResultList();
        productos.forEach(System.out::println);
    }
}
