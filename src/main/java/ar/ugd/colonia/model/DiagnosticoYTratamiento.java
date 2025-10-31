package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Representa el diagnóstico y tratamiento resultante de un estudio veterinario.
 * Depende de un estudio y se asocia también al gato al que corresponde.
 */
@Entity
@Table(name = "diagnostico_tratamiento")
public class DiagnosticoYTratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnostico;

    @Column(length = 255, nullable = false)
    private String diagnostico;

    @Column(length = 255)
    private String tratamiento;

    @Column(nullable = false)
    private LocalDate fecha;

    // === Relaciones ===
    @OneToOne
    @JoinColumn(name = "idEstudio", unique = true)
    private Estudio estudio;

    @ManyToOne
    @JoinColumn(name = "idGato")
    private Gato gato;

    @OneToOne(mappedBy = "diagnostico", cascade = CascadeType.ALL)
    private CertificadoAptitud certificado;

    // === Constructores ===
    public DiagnosticoYTratamiento() {}

    public DiagnosticoYTratamiento(String diagnostico, String tratamiento,
                                   LocalDate fecha, Estudio estudio, Gato gato) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
        this.estudio = estudio;
        this.gato = gato;
    }

    // === Getters/Setters ===
    public Integer getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(Integer idDiagnostico) { this.idDiagnostico = idDiagnostico; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getTratamiento() { return tratamiento; }
    public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Estudio getEstudio() { return estudio; }
    public void setEstudio(Estudio estudio) { this.estudio = estudio; }

    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }

    public CertificadoAptitud getCertificado() { return certificado; }
    public void setCertificado(CertificadoAptitud certificado) { this.certificado = certificado; }
}
