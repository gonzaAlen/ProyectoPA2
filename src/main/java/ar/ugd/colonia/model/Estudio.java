package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa un estudio médico realizado por un veterinario a un gato.
 * Puede generar un diagnóstico y tratamiento posterior.
 */
@Entity
@Table(name = "estudio")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudio;

    @Column(length = 100, nullable = false)
    private String tipoEstudio;

    @Column(length = 255)
    private String observaciones;

    @Column(nullable = false)
    private LocalDate fechaRealizacion;

    // === Relaciones ===
    @ManyToOne
    @JoinColumn(name = "idVeterinario")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "idGato")
    private Gato gato;

    @OneToOne(mappedBy = "estudio", cascade = CascadeType.ALL)
    private DiagnosticoYTratamiento diagnostico;

    // === Constructores ===
    public Estudio() {}

    public Estudio(String tipoEstudio, String observaciones,
                   LocalDate fechaRealizacion, Veterinario veterinario, Gato gato) {
        this.tipoEstudio = tipoEstudio;
        this.observaciones = observaciones;
        this.fechaRealizacion = fechaRealizacion;
        this.veterinario = veterinario;
        this.gato = gato;
    }

    // === Getters/Setters ===
    public Integer getIdEstudio() { return idEstudio; }
    public void setIdEstudio(Integer idEstudio) { this.idEstudio = idEstudio; }

    public String getTipoEstudio() { return tipoEstudio; }
    public void setTipoEstudio(String tipoEstudio) { this.tipoEstudio = tipoEstudio; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public LocalDate getFechaRealizacion() { return fechaRealizacion; }
    public void setFechaRealizacion(LocalDate fechaRealizacion) { this.fechaRealizacion = fechaRealizacion; }

    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }

    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }

    public DiagnosticoYTratamiento getDiagnostico() { return diagnostico; }
    public void setDiagnostico(DiagnosticoYTratamiento diagnostico) { this.diagnostico = diagnostico; }
}
