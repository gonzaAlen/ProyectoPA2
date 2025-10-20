package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase base de reportes con fecha y hora.
 * Las subclases agregan métricas específicas.
 */
public class Reporte {
    private int idReporte;
    private LocalDate fecha;
    private LocalTime hora;

    public Reporte() {}

    // Getters/Setters
    public int getIdReporte() { return idReporte; }
    public void setIdReporte(int idReporte) { this.idReporte = idReporte; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
}
