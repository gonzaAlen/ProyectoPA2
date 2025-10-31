package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Registra un avistamiento de un gato en la vía pública.
 * Puede o no estar asociado a una tarea o voluntario específico.
 */
@Entity
@Table(name = "registro_avistamiento")
public class RegistroAvistamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAvistamiento;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255)
    private String ubicacion;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 100)
    private String estadoDelGato; // "Herido", "Sano", "Desnutrido", etc.

    // === Relaciones ===

    @ManyToOne
    @JoinColumn(name = "idVoluntario")
    private Voluntario voluntario; // quien registró el avistamiento



    public RegistroAvistamiento() {}

    public RegistroAvistamiento(LocalDate fecha, String ubicacion, String descripcion,
                                String estadoDelGato, Voluntario voluntario, Gato gato) {
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.estadoDelGato = estadoDelGato;
        this.voluntario = voluntario;
    }

    // === Getters/Setters ===
    public Integer getIdAvistamiento() { return idAvistamiento; }
    public void setIdAvistamiento(Integer idAvistamiento) { this.idAvistamiento = idAvistamiento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstadoDelGato() { return estadoDelGato; }
    public void setEstadoDelGato(String estadoDelGato) { this.estadoDelGato = estadoDelGato; }

    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }

}
