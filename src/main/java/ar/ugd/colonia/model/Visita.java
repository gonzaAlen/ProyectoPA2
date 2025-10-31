package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa una visita de control o seguimiento
 * realizada por un voluntario a una familia o un gato.
 */
@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVisita;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255)
    private String observaciones;

    @Column(length = 30)
    private String tipo; // "ADOPCION", "TRANSITO", "CONTROL", etc.

    // === Relaciones ===

    @ManyToOne
    @JoinColumn(name = "idVoluntario")
    private Voluntario voluntario;

    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private FamiliaAdoptante familia;

    @ManyToOne
    @JoinColumn(name = "idGato")
    private Gato gato;

    public Visita() {}

    public Visita(LocalDate fecha, String observaciones, String tipo,
                  Voluntario voluntario, FamiliaAdoptante familia, Gato gato) {
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.tipo = tipo;
        this.voluntario = voluntario;
        this.familia = familia;
        this.gato = gato;
    }

    // === Getters/Setters ===
    public Integer getIdVisita() { return idVisita; }
    public void setIdVisita(Integer idVisita) { this.idVisita = idVisita; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }

    public FamiliaAdoptante getFamilia() { return familia; }
    public void setFamilia(FamiliaAdoptante familia) { this.familia = familia; }

    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
