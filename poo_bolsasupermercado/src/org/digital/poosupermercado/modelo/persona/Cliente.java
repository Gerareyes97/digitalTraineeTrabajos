package org.digital.poosupermercado.modelo.persona;

import org.digital.poosupermercado.repositorio.Identificable;

public class Cliente extends Persona {

    private int puntos;

    public Cliente(int id, String nombre, String email, int puntos) {
        super(id, nombre, email);
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "Puntos: " + this.puntos;
    }

}
