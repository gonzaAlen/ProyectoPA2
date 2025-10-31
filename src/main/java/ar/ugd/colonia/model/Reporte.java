package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase base para los reportes generados en el sistema.
 * Puede ser compartido entre varios administradores.
 */
@Entity
@Table(name = "reporte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporte;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(length = 255)
    private String descripcion;

    // === Relaciones ===
    @ManyToMany(mappedBy = "reportes")
    private List<Administrador> administradores;

    // === Constructores ===
    public Reporte() {}

    public Reporte(String titulo, LocalDate fechaEmision, String descripcion) {
        this.titulo = titulo;
        this.fechaEmision = fechaEmision;
        this.descripcion = descripcion;
    }

    // === Getters/Setters ===
    public Integer getIdReporte() { return idReporte; }
    public void setIdReporte(Integer idReporte) { this.idReporte = idReporte; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Administrador> getAdministradores() { return administradores; }
    public void setAdministradores(List<Administrador> administradores) { this.administradores = administradores; }
}
