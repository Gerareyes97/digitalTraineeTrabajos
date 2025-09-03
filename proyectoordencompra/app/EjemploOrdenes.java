package org.proyectoordencompra.app;

import org.proyectoordencompra.model.*;
import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args) {

        //orden1
        OrdenCompra orden1 = new OrdenCompra("Orden de computacion");
        orden1.setCliente(new Cliente("Lucia", "Flores"));
        orden1.setFecha(new Date());
        //Agregando Productos
        orden1.addProducto(new Producto("Dell", "Laptop XPS", 1200));
        orden1.addProducto(new Producto("Logitech", "Mouse MX Master", 150));
        orden1.addProducto(new Producto("Samsung", "Monitor 27\"", 300));
        orden1.addProducto(new Producto("Kingston", "SSD 1TB", 100));

        //Orden2
        OrdenCompra orden2 = new OrdenCompra("Orden de oficina");
        orden2.setCliente(new Cliente("Fernando", "Flores"));
        orden2.setFecha(new Date());
        //Agregando productos
        orden2.addProducto(new Producto("HP", "Impresora Laser", 200));
        orden2.addProducto(new Producto("Brother", "Escaner", 180));
        orden2.addProducto(new Producto("Epson", "Proyector", 400));
        orden2.addProducto(new Producto("Sony", "Telefono IP", 250));

        //Orden3
        OrdenCompra orden3 = new OrdenCompra("Orden de entretenimiendo");
        orden3.setCliente(new Cliente("Luis", "Flores"));
        orden3.setFecha(new Date());
        //Agregando Productos
        orden3.addProducto(new Producto("Sony", "PlayStation5", 500));
        orden3.addProducto(new Producto("Nintendo", "Switch OLED", 350));
        orden3.addProducto(new Producto("LG", "Smart TV 55\"", 800));
        orden3.addProducto(new Producto("Vose", "Soundbar", 300));

        OrdenCompra[] ordenes = {orden1, orden2, orden3};

        for (OrdenCompra orden: ordenes){
            System.out.println(orden);
            System.out.println("===========");
        }
    }
}
