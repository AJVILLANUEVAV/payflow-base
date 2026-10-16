package com.nttdata.payflow.model;

/**
 * Clase base abstracta de todos los tipos de empleado.
 */
public abstract class Empleado {

    private final String id;
    private final String nombre;
    private final Area area;

    protected Empleado(String id, String nombre, Area area) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede ser nulo ni vacío");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
        if (area == null) {
            throw new IllegalArgumentException("El área no puede ser nula");
        }

        this.id = id;
        this.nombre = nombre;
        this.area = area;
    }

    public abstract double calcularPagoMensual();

    public abstract String getTipo();

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Area getArea() {
        return area;
    }
}