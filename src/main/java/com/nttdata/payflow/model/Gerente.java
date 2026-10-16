package com.nttdata.payflow.model;

/**
 * Un gerente es un empleado de planilla con bono de gestión.
 */
public class Gerente extends EmpleadoPlanilla {

    public Gerente(String id, String nombre, Area area,
                   double sueldoBase, boolean tieneHijos, int evaluacion) {
        super(id, nombre, area, sueldoBase, tieneHijos, evaluacion);
    }

    @Override
    public double calcularBono() {
        return super.calcularBono() + getSueldoBase() * 0.20;
    }

    @Override
    public String getTipo() {
        return "Gerente";
    }
}
