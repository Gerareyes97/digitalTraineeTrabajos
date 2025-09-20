package org.greyes.digital.ejemplo.dominio;

import java.math.BigDecimal;

public class ProductoDto {

        private String nombre;
        private String descripcion;
        private BigDecimal precio;
        private Integer cantidad;

        public ProductoDto(String nombre, String descripcion, BigDecimal precio, Integer cantidad) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public BigDecimal getPrecio() {
            return precio;
        }

        public void setPrecio(BigDecimal precio) {
            this.precio = precio;
        }

        public Integer getCantidad() {
            return cantidad;
        }

        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return "ProductoDto{" +
                    "nombre='" + nombre + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", precio=" + precio +
                    ", cantidad=" + cantidad +
                    '}';
        }
}
