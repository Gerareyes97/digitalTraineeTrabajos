package org.digital.poosupermercado.modelo.persona;

import org.digital.poosupermercado.repositorio.Identificable;

import java.util.Objects;

abstract public class Persona  implements IPersona, Identificable {

    protected int id;
    protected String nombre;
    protected String email;

    public Persona(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String mostrarInfo() {
        return "ID: " + this.id
                + "\nNombre: " + this.nombre
                + "\nCorreo Electronico: " + this.email;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return id == persona.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
