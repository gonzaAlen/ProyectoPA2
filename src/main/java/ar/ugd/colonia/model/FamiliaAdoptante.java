package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Representa una familia adoptante que puede tener varios gatos asignados
 * y participar en registros de adopciones o visitas.
 */
@Entity
@Table(name = "familia_adoptante")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class FamiliaAdoptante extends Usuario {

    @Column(length = 100)
    private String correoElectronicoDesignado;

    @Column(length = 20)
    private String numeroTelefonoDesignado;

    @Column(length = 120)
    private String direccion;

    @Column(length = 30)
    private String estadoDeFamilia;

    @Column(length = 30)
    private String disponibilidadDeFamilia;

    @Column(length = 30)
    private String reputacion;

    @Column(length = 255)
    private String detallesDeReputacion;

    // === Relaciones ===
    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<Gato> gatos; // gatos adoptados o en tránsito

    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<Visita> visitas; // visitas de control

    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<RegistroAdopcionesTransitos> registros; // adopciones o tránsitos realizados

    // === Constructores ===
    public FamiliaAdoptante() {
        super();
        setRol("FAMILIA");
    }

    public FamiliaAdoptante(String nombre, String contrasena,
                            String correo, String telefono, String direccion,
                            String estado, String disponibilidad,
                            String reputacion, String detalles) {
        super(nombre, contrasena, "FAMILIA");
        this.correoElectronicoDesignado = correo;
        this.numeroTelefonoDesignado = telefono;
        this.direccion = direccion;
        this.estadoDeFamilia = estado;
        this.disponibilidadDeFamilia = disponibilidad;
        this.reputacion = reputacion;
        this.detallesDeReputacion = detalles;
    }

    // === Getters/Setters ===
    public String getCorreoElectronicoDesignado() { return correoElectronicoDesignado; }
    public void setCorreoElectronicoDesignado(String v) { this.correoElectronicoDesignado = v; }

    public String getNumeroTelefonoDesignado() { return numeroTelefonoDesignado; }
    public void setNumeroTelefonoDesignado(String v) { this.numeroTelefonoDesignado = v; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String v) { this.direccion = v; }

    public String getEstadoDeFamilia() { return estadoDeFamilia; }
    public void setEstadoDeFamilia(String v) { this.estadoDeFamilia = v; }

    public String getDisponibilidadDeFamilia() { return disponibilidadDeFamilia; }
    public void setDisponibilidadDeFamilia(String v) { this.disponibilidadDeFamilia = v; }

    public String getReputacion() { return reputacion; }
    public void setReputacion(String v) { this.reputacion = v; }

    public String getDetallesDeReputacion() { return detallesDeReputacion; }
    public void setDetallesDeReputacion(String v) { this.detallesDeReputacion = v; }

    public List<Gato> getGatos() { return gatos; }
    public void setGatos(List<Gato> gatos) { this.gatos = gatos; }

    public List<Visita> getVisitas() { return visitas; }
    public void setVisitas(List<Visita> visitas) { this.visitas = visitas; }

    public List<RegistroAdopcionesTransitos> getRegistros() { return registros; }
    public void setRegistros(List<RegistroAdopcionesTransitos> registros) { this.registros = registros; }
}
