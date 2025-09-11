package org.digital.poosupermercado.app;

import org.digital.poosupermercado.modelo.*;
import org.digital.poosupermercado.repositorio.excepciones.*;
import org.digital.poosupermercado.repositorio.lista.ProductoRepositorio;

public class SupermercadoCrud {
    public static void main(String[] args) throws LecturaAccesoDatoException, EscrituraAccesoDatoException {

        try {

            ProductoRepositorio productoRepo = new ProductoRepositorio();

            System.out.println(" ====== CREAR ====== ");

            productoRepo.crear(new Lacteo(1, "Leche", 5.25, 2, 8));
            productoRepo.crear(new Lacteo(2, "Yogurt", 2.25, 6, 5));
            productoRepo.crear(new Fruta(3, "Manzana", 2.45, 2.0, "Rojo"));
            productoRepo.crear(new Limpieza(4, "Jabón líquido", 4.00, "Aromas", 1.5));
            productoRepo.crear(new NoPerecible(5, "Frijoles", 7.50, 500, 1500));

            System.out.println(" ====== LISTAR ====== ");
            productoRepo.listar().forEach(p -> System.out.println(p.descripcion()));

            System.out.println(" ====== BUSCAR ====== ");
            Producto producto = productoRepo.porId(3);
            System.out.println(producto != null ? producto.descripcion() : "Producto no encontrado");

            System.out.println(" ====== EDITAR ====== ");
            Producto editado = new Fruta(3, "Manzana Verde", 1.75, 2.1, "Verde");
            productoRepo.editar(editado);
            productoRepo.listar().forEach(p -> System.out.println(p.descripcion()));

            System.out.println(" ====== ELIMINAR ====== ");
            productoRepo.eliminar(1);
            productoRepo.listar().forEach(p -> System.out.println(p.descripcion()));

        } catch (AccesoDatoException e){
            System.out.println("Registro no encontrado: : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
