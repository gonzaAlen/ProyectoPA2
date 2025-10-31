package ar.ugd.colonia.model;

import jakarta.persistence.*;

/**
 * Reporte con información detallada sobre un gato específico.
 */
@Entity
@Table(name = "reporte_de_gatos")
@PrimaryKeyJoinColumn(name = "idReporte")
public class ReporteDeGatos extends Reporte {

    @Column(length = 255)
    private String observacionesGenerales;

    private Integer totalGatos;

    // === Relaciones ===
    @ManyToOne
    @JoinColumn(name = "idGato")
    private Gato gato;

    public ReporteDeGatos() {}

    public ReporteDeGatos(String titulo, String descripcion,
                          String observacionesGenerales, Integer totalGatos, Gato gato) {
        super(titulo, java.time.LocalDate.now(), descripcion);
        this.observacionesGenerales = observacionesGenerales;
        this.totalGatos = totalGatos;
        this.gato = gato;
    }

    // === Getters/Setters ===
    public String getObservacionesGenerales() { return observacionesGenerales; }
    public void setObservacionesGenerales(String observacionesGenerales) { this.observacionesGenerales = observacionesGenerales; }

    public Integer getTotalGatos() { return totalGatos; }
    public void setTotalGatos(Integer totalGatos) { this.totalGatos = totalGatos; }

    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
