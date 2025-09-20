package org.greyes.digital.ejemplo;

import jakarta.persistence.EntityManager;
import org.greyes.digital.ejemplo.entity.Cliente;
import org.greyes.digital.ejemplo.entity.Producto;
import org.greyes.digital.ejemplo.services.ProductoService;
import org.greyes.digital.ejemplo.services.ProductoServiceImpl;
import org.greyes.digital.ejemplo.util.JpaUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class HibernateCrudProducto {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        ProductoService service = new ProductoServiceImpl(em);

        System.out.println("=== Listar ===");
        List<Producto> productos = service.listar();
        productos.forEach(System.out::println);

        System.out.println("=== Obtener por id ===");
        Optional<Producto> optionalProducto = service.porId(1L);
        optionalProducto.ifPresent(System.out::println);

        System.out.println("=== Insertar ===");
        Producto producto = new Producto();
        producto.setNombre("iPhone 17 Pro Max");
        producto.setDescripcion("Pantalla Super Retina XDR");
        producto.setPrecio(new BigDecimal("1299.99"));
        producto.setCantidad(10);
        service.guardar(producto);
        service.listar().forEach(System.out::println);

        System.out.println("=== Editar ===");
        Long id = producto.getId();
        Optional<Producto> op = service.porId(id);
        op.ifPresent(prod -> {
            prod.setPrecio(new BigDecimal("1100.00"));
            service.guardar(prod);
            System.out.println("Producto editado correctamente");
        });

        System.out.println("=== Eliminar producto ===");
        id =producto.getId();
        op = service.porId(id);
        op.ifPresent(prod -> {
            service.eliminar(prod.getId());
            System.out.println("Producto eliminado");
        });

        service.listar().forEach(System.out::println);
        em.close();
    }
}
