package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa a un administrador del sistema.
 * Puede generar reportes junto a otros administradores.
 */
@Entity
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Administrador extends Usuario {

    // === Relaciones ===
    @ManyToMany
    @JoinTable(
        name = "administrador_reporte",
        joinColumns = @JoinColumn(name = "idAdministrador"),
        inverseJoinColumns = @JoinColumn(name = "idReporte")
    )
    private List<Reporte> reportes;

    public Administrador() {
        super();
        setRol("ADMINISTRADOR");
    }

    public Administrador(String nombre, String contrasena) {
        super(nombre, contrasena, "ADMINISTRADOR");
    }

    // === Getters/Setters ===
    public List<Reporte> getReportes() { return reportes; }
    public void setReportes(List<Reporte> reportes) { this.reportes = reportes; }
}
