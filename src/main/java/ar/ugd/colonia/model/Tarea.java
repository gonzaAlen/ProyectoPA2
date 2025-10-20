package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa una tarea realizada por un voluntario para un gato.
 * El tipo se modela como texto por ahora (ALIMENTACION, CAPTURA, CONTROL, TRANSPORTE).
 */
public class Tarea {
    private int idTarea;
    private String tipoTarea;     // luego puede ser enum
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private String estado;        // PENDIENTE, HECHA, CANCELADA

    // Relaciones lógicas (referencias) para futura integración
    private Voluntario voluntario; 
    private Gato gato;

    public Tarea() {}

    public void agregarTarea() { /* persistencia en capa DAO */ }
    public void actualizarTarea() { /* persistencia en capa DAO */ }
    public Tarea getTarea() { return this; }

    // Getters/Setters
    public int getIdTarea() { return idTarea; }
    public void setIdTarea(int idTarea) { this.idTarea = idTarea; }
    public String getTipoTarea() { return tipoTarea; }
    public void setTipoTarea(String tipoTarea) { this.tipoTarea = tipoTarea; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }
    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
