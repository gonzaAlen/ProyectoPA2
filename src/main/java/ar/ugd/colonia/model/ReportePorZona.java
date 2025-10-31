package ar.ugd.colonia.model;

import jakarta.persistence.*;

/**
 * Reporte que agrupa información por zona geográfica.
 */
@Entity
@Table(name = "reporte_por_zona")
@PrimaryKeyJoinColumn(name = "idReporte")
public class ReportePorZona extends Reporte {

    @Column(length = 60, nullable = false)
    private String zona;

    @Column(length = 255)
    private String resumen;

    public ReportePorZona() {}

    public ReportePorZona(String titulo, String descripcion,
                          String zona, String resumen) {
        super(titulo, java.time.LocalDate.now(), descripcion);
        this.zona = zona;
        this.resumen = resumen;
    }

    // Getters/Setters
    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }

    public String getResumen() { return resumen; }
    public void setResumen(String resumen) { this.resumen = resumen; }
}
