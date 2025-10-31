package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa una tarea asignada a un voluntario sobre un gato.
 * Ejemplo: “Revisar estado de salud”, “Llevar al veterinario”, etc.
 */
@Entity
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;

    @Column(length = 100, nullable = false)
    private String descripcion;

    @Column(length = 30, nullable = false)
    private String tipo;

    @Column(length = 20, nullable = false)
    private String estado;

    @Column(nullable = false)
    private LocalDate fechaAsignacion;

    // === Relaciones ===
    @ManyToOne
    @JoinColumn(name = "idVoluntario")
    private Voluntario voluntario;

    @ManyToOne
    @JoinColumn(name = "idGato")
    private Gato gato;

    // === Constructores ===
    public Tarea() {}

    public Tarea(String descripcion, String tipo, String estado,
                 LocalDate fechaAsignacion, Voluntario voluntario, Gato gato) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaAsignacion = fechaAsignacion;
        this.voluntario = voluntario;
        this.gato = gato;
    }

    // === Getters/Setters ===
    public Integer getIdTarea() { return idTarea; }
    public void setIdTarea(Integer idTarea) { this.idTarea = idTarea; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }

    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }

    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
