package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Registra la entrega temporal o definitiva de un gato a una familia adoptante.
 * Permite identificar si el proceso fue una adopción o un tránsito.
 */
@Entity
@Table(name = "registro_adopciones_transitos")
public class RegistroAdopcionesTransitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistro;

    @Column(length = 20, nullable = false)
    private String tipo; // "ADOPCION" o "TRANSITO"

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    @Column(length = 255)
    private String observaciones;

    // === Relaciones ===

    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private FamiliaAdoptante familia;

    @ManyToOne
    @JoinColumn(name = "idGato")
    private Gato gato;

    @ManyToOne
    @JoinColumn(name = "idVoluntario")
    private Voluntario voluntario; // voluntario que gestionó la entrega

    public RegistroAdopcionesTransitos() {}

    public RegistroAdopcionesTransitos(String tipo, LocalDate fechaInicio, LocalDate fechaFin,
                                       String observaciones, FamiliaAdoptante familia,
                                       Gato gato, Voluntario voluntario) {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.observaciones = observaciones;
        this.familia = familia;
        this.gato = gato;
        this.voluntario = voluntario;
    }

    // === Getters/Setters ===
    public Integer getIdRegistro() { return idRegistro; }
    public void setIdRegistro(Integer idRegistro) { this.idRegistro = idRegistro; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public FamiliaAdoptante getFamilia() { return familia; }
    public void setFamilia(FamiliaAdoptante familia) { this.familia = familia; }

    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }

    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }
}
