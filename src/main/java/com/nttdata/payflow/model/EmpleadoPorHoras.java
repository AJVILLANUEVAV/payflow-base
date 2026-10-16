package com.nttdata.payflow.model;

/**
 * Empleado que cobra por horas trabajadas.
 */
public class EmpleadoPorHoras extends Empleado {

    private static final int HORAS_ORDINARIAS_MAXIMAS = 160;
    private static final double FACTOR_HORA_EXTRA = 1.5;

    private final double tarifaHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String id, String nombre, Area area, double tarifaHora) {
        super(id, nombre, area);
        if (!Double.isFinite(tarifaHora) || tarifaHora <= 0) {
            throw new IllegalArgumentException("La tarifa por hora debe ser positiva y finita");
        }
        this.tarifaHora = tarifaHora;
    }

    public void registrarHoras(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }
        this.horasTrabajadas = horas;
    }

    @Override
    public double calcularPagoMensual() {
        int horasOrdinarias = Math.min(horasTrabajadas, HORAS_ORDINARIAS_MAXIMAS);
        int horasExtra = Math.max(0, horasTrabajadas - HORAS_ORDINARIAS_MAXIMAS);
        return horasOrdinarias * tarifaHora + horasExtra * tarifaHora * FACTOR_HORA_EXTRA;
    }

    @Override
    public String getTipo() {
        return "Por horas";
    }
}
