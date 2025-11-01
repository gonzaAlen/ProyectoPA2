package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa un gato registrado en la colonia o adoptado por una familia.
 */
@Entity
@Table(name = "gato")
public class Gato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGato;

    @Column(length = 80, nullable = false)
    private String nombre;

    @Column(length = 40)
    private String color;

    @Column(length = 255)
    private String caracteristicas;

    @Column(length = 255)
    private String foto;

    @Column(length = 30)
    private String estadoDeSalud;

    private Integer edadAproximada;

    @Column(length = 80, unique = true)
    private String codigoQR;

    // === Relaciones ===
    @ManyToOne
    @JoinColumn(name = "idFamilia")
    private FamiliaAdoptante familia;

    @OneToMany(mappedBy = "gato", cascade = CascadeType.ALL)
    private List<Estudio> estudios;

    @OneToMany(mappedBy = "gato", cascade = CascadeType.ALL)
    private List<DiagnosticoYTratamiento> diagnosticos;

    @OneToMany(mappedBy = "gato", cascade = CascadeType.ALL)
    private List<ReporteDeGatos> reportes;

    @OneToMany(mappedBy = "gato", cascade = CascadeType.ALL)
    private List<Visita> visitas;

    public Gato() {}

    public Gato(String nombre, String color, String caracteristicas,
                String estadoDeSalud, Integer edadAproximada,
                String foto, String codigoQR) {
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.estadoDeSalud = estadoDeSalud;
        this.edadAproximada = edadAproximada;
        this.foto = foto;
        this.codigoQR = codigoQR;
    }

    // === Getters/Setters ===
    public Integer getIdGato() { return idGato; }
    public void setIdGato(Integer idGato) { this.idGato = idGato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String caracteristicas) { this.caracteristicas = caracteristicas; }

    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }

    public String getEstadoDeSalud() { return estadoDeSalud; }
    public void setEstadoDeSalud(String estadoDeSalud) { this.estadoDeSalud = estadoDeSalud; }

    public Integer getEdadAproximada() { return edadAproximada; }
    public void setEdadAproximada(Integer edadAproximada) { this.edadAproximada = edadAproximada; }

    public String getCodigoQR() { return codigoQR; }
    public void setCodigoQR(String codigoQR) { this.codigoQR = codigoQR; }

    public FamiliaAdoptante getFamilia() { return familia; }
    public void setFamilia(FamiliaAdoptante familia) { this.familia = familia; }

    public List<Estudio> getEstudios() { return estudios; }
    public void setEstudios(List<Estudio> estudios) { this.estudios = estudios; }

    public List<DiagnosticoYTratamiento> getDiagnosticos() { return diagnosticos; }
    public void setDiagnosticos(List<DiagnosticoYTratamiento> diagnosticos) { this.diagnosticos = diagnosticos; }

    public List<ReporteDeGatos> getReportes() { return reportes; }
    public void setReportes(List<ReporteDeGatos> reportes) { this.reportes = reportes; }

    public List<Visita> getVisitas() { return visitas; }
    public void setVisitas(List<Visita> visitas) { this.visitas = visitas; }

    
}
