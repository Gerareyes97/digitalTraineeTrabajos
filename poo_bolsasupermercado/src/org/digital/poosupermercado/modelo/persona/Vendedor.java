package org.digital.poosupermercado.modelo.persona;

import org.digital.poosupermercado.repositorio.Identificable;

public class Vendedor extends Persona {

    private double salario;

    public Vendedor(int id, String nombre, String email, double salario) {
        super(id, nombre, email);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "Salario: $" + this.salario;
    }

}
