package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Certifica que un gato se encuentra en condiciones aptas
 * para adopción o tránsito, a partir de un diagnóstico.
 */
@Entity
@Table(name = "certificado_aptitud")
public class CertificadoAptitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCertificado;

    @Column(length = 255)
    private String observaciones;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    // === Relaciones ===
    @ManyToOne
    @JoinColumn(name = "idDiagnostico")
    private DiagnosticoYTratamiento diagnostico;

    // === Constructores ===
    public CertificadoAptitud() {}

    public CertificadoAptitud(String observaciones, LocalDate fechaEmision,
                              DiagnosticoYTratamiento diagnostico) {
        this.observaciones = observaciones;
        this.fechaEmision = fechaEmision;
        this.diagnostico = diagnostico;
    }

    // === Getters/Setters ===
    public Integer getIdCertificado() { return idCertificado; }
    public void setIdCertificado(Integer idCertificado) { this.idCertificado = idCertificado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public DiagnosticoYTratamiento getDiagnostico() { return diagnostico; }
    public void setDiagnostico(DiagnosticoYTratamiento diagnostico) { this.diagnostico = diagnostico; }
}
