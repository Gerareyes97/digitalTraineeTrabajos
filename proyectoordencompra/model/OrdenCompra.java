package org.proyectoordencompra.model;

import java.util.Arrays;
import java.util.Date;

public class OrdenCompra {

    private static int contadorOrden;
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private int indiceProducto;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.id = ++contadorOrden;
        this.productos = new Producto[4];
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void addProducto(Producto producto){
        if (indiceProducto < this.productos.length){
            this.productos[indiceProducto++] = producto;
        } else {
            System.err.println("No se pueden agregar mas productos");
        }
    }

    public int granTotal(){
        int total = 0;

        for (Producto pro: productos){
            if (pro != null){
                total += pro.getPrecio();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        String detalle =  "Folio: " + this.getId() +
                "\nDescripcion: " + this.getDescripcion() +
                "\nFecha: " + this.getFecha() +
                "\nCliente: " + this.getCliente() +
                "\nListado: ";

        for (Producto produc: productos){
            if (produc != null){
                detalle += produc.toString() + "\n";
            }
        }
        detalle += "\nTotal: $" + this.granTotal();
        return detalle;

    }
}
