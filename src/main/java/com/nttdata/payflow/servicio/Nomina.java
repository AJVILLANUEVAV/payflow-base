package com.nttdata.payflow.servicio;

import com.nttdata.payflow.model.Area;
import com.nttdata.payflow.model.Boleta;
import com.nttdata.payflow.model.Empleado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * La nómina contiene y administra a los empleados.
 */
public class Nomina {
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregar(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        boolean idDuplicado = empleados.stream()
                .anyMatch(registrado -> registrado.getId().equals(empleado.getId()));
        if (idDuplicado) {
            throw new IllegalArgumentException("Ya existe un empleado con el id " + empleado.getId());
        }
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    public double totalNomina() {
        return empleados.stream()
                .mapToDouble(Empleado::calcularPagoMensual)
                .sum();
    }

    public double totalPorArea(Area area) {
        return empleados.stream()
                .filter(empleado -> empleado.getArea() == area)
                .mapToDouble(Empleado::calcularPagoMensual)
                .sum();
    }

    public List<Boleta> generarBoletas() {
        return empleados.stream()
                .map(e -> new Boleta(e.getId(), e.getNombre(), e.getTipo(), e.calcularPagoMensual()))
                .toList();
    }
}
