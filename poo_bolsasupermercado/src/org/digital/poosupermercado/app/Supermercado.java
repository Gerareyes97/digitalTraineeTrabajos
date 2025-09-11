package org.digital.poosupermercado.app;

import org.digital.poosupermercado.modelo.*;
import org.digital.poosupermercado.modelo.persona.*;
import org.digital.poosupermercado.repositorio.Direccion;
import org.digital.poosupermercado.repositorio.excepciones.*;
import org.digital.poosupermercado.repositorio.lista.*;

public class Supermercado {
    public static void main(String[] args) throws EscrituraAccesoDatoException, RegistroDuplicadoException, LecturaAccesoDatoException, SinDatosException{

        try {
            BolsaSupermercado<Producto> bolsaProductos = new BolsaSupermercado<>();
            bolsaProductos.addProductos(new Lacteo(1, "Leche", 5.25, 2, 8))
                    .addProductos(new Lacteo(2, "Yogurt", 2.25, 3, 5))
                    .addProductos(new Lacteo(3, "Queso Fresco", 4.00, 1, 12))
                    .addProductos(new Lacteo(4, "Mantequilla", 1.75, 2, 10))
                    .addProductos(new Lacteo(5, "Crema", 3.00, 2, 14))

                    .addProductos(new Fruta(1, "Manzana", 1.50, 0.2, "Rojo"))
                    .addProductos(new Fruta(2, "Pera", 0.75, 0.40, "Verde"))
                    .addProductos(new Fruta(3, "Banana", 1.00, 0.3, "Amarillo"))
                    .addProductos(new Fruta(4, "Naranja", 2.50, 0.40, "Naranja"))
                    .addProductos(new Fruta(5, "Uva", 4.00, 0.5, "Morado"))

                    .addProductos(new Limpieza(1, "Jabón líquido", 2.80, "Aromas", 1))
                    .addProductos(new Limpieza(2, "Desinfectante", 4.00, "Cloro", 1.5))
                    .addProductos(new Limpieza(3, "Suavizante", 6.75, "Perfume floral", 1.0))
                    .addProductos(new Limpieza(4, "Limpiavidrios", 3.25, "Alcohol", 1))

                    .addProductos(new NoPerecible(1, "Frijoles", 7.50, 500, 1500))
                    .addProductos(new NoPerecible(2, "Pasta", 0.85, 300, 1200))
                    .addProductos(new NoPerecible(3, "Harina", 1.10, 1000, 2000))
                    .addProductos(new NoPerecible(4, "Lentejas", 1.45, 450, 1600));

            for (Producto pro : bolsaProductos.getProductos()) {
                System.out.println("ID: " + pro.getId());
                System.out.println("Tipo: " + pro.getClass().getSimpleName());
                System.out.println("Nombre: " + pro.getNombre());
                System.out.println("Precio: $" + pro.getPrecio());

                if (pro instanceof Lacteo) {
                    System.out.println("Cantidad: " + ((Lacteo) pro).getCantidad()
                            + "\nProteínas: " + ((Lacteo) pro).getProteinas());
                }

                if (pro instanceof Fruta) {
                    System.out.println("Peso: " + ((Fruta) pro).getPeso()
                            + "\nColor: " + ((Fruta) pro).getColor());
                }

                if (pro instanceof Limpieza) {
                    System.out.println("Componentes: " + ((Limpieza) pro).getComponentes()
                            + "\nLitros: " + ((Limpieza) pro).getLitros());
                }

                if (pro instanceof NoPerecible) {
                    System.out.println("Contenido: " + ((NoPerecible) pro).getContenido() +
                            "g \nCalorias: " + ((NoPerecible) pro).getCalorias());
                }

                System.out.println("-------------------------------");
            }

            System.out.println("====== PRODUCTOS REPOSITORIO ======");

            ProductoRepositorio productoRepo = new ProductoRepositorio();

            bolsaProductos.getProductos().forEach(p -> {
                try {
                    productoRepo.crear(p);
                } catch (AccesoDatoException e) {
                    System.out.println("Error al crear producto: " + e.getMessage());
                }
            });


            System.out.println("====== Productos en el repositorio =====");
            productoRepo.listar().forEach(p -> System.out.println(p.descripcion()));

            System.out.println("====== Productos ordenados por nomnre (ASC) =====");
            productoRepo.listar("nombre", Direccion.ASC).forEach(p -> System.out.println(p.getNombre()));

            System.out.println("====== Productos filtrados por categoria =====");
            productoRepo.listaPorCategoria("Lacteo", 5).forEach(p -> System.out.println(p.getNombre()));


            System.out.println("====== CLIENTES REPOSITORIO ======");

            ClienteRepositorio clienteRepo = new ClienteRepositorio();
            clienteRepo.crear(new Cliente(1, "Lucia Flores", "lucia@correo.com", 120));
            clienteRepo.crear(new Cliente(2, "Luis Martinez", "luis@correo.com", 300));
            clienteRepo.crear(new Cliente(3, "Fernando Duarte", "fernando@correo.com", 250));
            clienteRepo.crear(new Cliente(4, "Gerardo Reyes", "gerardo@correo.com", 175));
            clienteRepo.crear(new Cliente(5, "Marcos Pineda", "marcos@correo.com", 1590));

            System.out.println("\n----- Clientes en el repositorio -----");
            clienteRepo.listar().forEach(c -> System.out.println(c.mostrarInfo()));

            System.out.println("\n----- Clientes por puntos entre 100 y 250 -----");
            clienteRepo.listaPorPuntos(100, 250, 10).forEach(c -> System.out.println(c.getPuntos()));

            System.out.println("====== VENDEDORES REPOSITORIO ======");

            VendedorRepositorio vendedorRepo = new VendedorRepositorio();
            vendedorRepo.crear(new Vendedor(1, "Carlos Lopez", "carlos@supermercado.com", 1200));
            vendedorRepo.crear(new Vendedor(2, "Rocio Pineda", "rocio@supermercado.com", 800));
            vendedorRepo.crear(new Vendedor(3, "Juan Gallardo", "juang@supermercado.com", 1375));
            vendedorRepo.crear(new Vendedor(4, "Francisco Rivera", "franriver@supermercado.com", 1000));
            vendedorRepo.crear(new Vendedor(5, "Marvin Ramos", "marvin@supermercado.com", 1500));

            System.out.println("\n----- Vendedores en el repositorio -----");
            vendedorRepo.listar().forEach(v -> System.out.println(v.getNombre()));

            System.out.println("\n----- Vendedores por salario entre 1000 y 1400 -----");
            vendedorRepo.listaPorSalario(1000, 1400, 10).forEach(v -> System.out.println(v.getSalario()));

            System.out.println("\n----- Vendedores ordenados por salario DESC -----");
            vendedorRepo.listar("salario", Direccion.DESC).forEach(v -> System.out.println(v.getNombre() + " - $" + v.getSalario()));

            System.out.println("====== LISTAR CANTIDAD ======");

            productoRepo.listarPorCantidad(10).forEach(p -> System.out.println(p.descripcion()));

            System.out.println("====== ORDENAR ======");
            productoRepo.listar("nombre", Direccion.ASC).forEach(p -> System.out.println(p.descripcion()));

            productoRepo.listar("precio", Direccion.DESC).forEach(p -> System.out.println(p.descripcion()));

            System.out.println("====== TOTAL ======");
            System.out.println(productoRepo.total());

        } catch (AccesoDatoException e){
            System.out.println("Registro no encontrado: : " + e.getMessage());
            e.printStackTrace();
        }

    }
}
