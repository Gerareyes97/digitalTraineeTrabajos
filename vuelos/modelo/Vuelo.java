package org.digital.vuelos.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vuelo {

    private String nombre;
    private String origen;
    private String destino;
    private LocalDateTime fechaLLegada;
    private int pasajeros;

    public Vuelo(String nombre, String origen, String destino,
                 LocalDateTime fechaLLegada, int pasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLLegada = fechaLLegada;
        this.pasajeros = pasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getFechaLLegada() {
        return fechaLLegada;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Nombre: " + nombre +
                "\nOrigen: " + origen +
                "\nDestino: " + destino +
                "\nFecha Llegada: " + fechaLLegada.format(f) +
                "\nPasajeros: " + pasajeros;
    }
}
