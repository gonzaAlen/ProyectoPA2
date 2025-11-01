package ar.ugd.colonia.model;

import jakarta.persistence.*;

/**
 * Representa a un voluntario del sistema.
 */
@Entity
@Table(name = "voluntario")
public class Voluntario {

    @Id
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(length = 80)
    private String correoElectronico;

    @Column(length = 100)
    private String direccion;

    @Column(length = 20)
    private String numeroTelefono;

    private Double reputacion;

    @Column(length = 255)
    private String detallesDeReputacion;

    // Relación con Usuario
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId   // usa la misma clave primaria del usuario
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    // === Getters y Setters ===

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Double getReputacion() {
        return reputacion;
    }

    public void setReputacion(Double reputacion) {
        this.reputacion = reputacion;
    }

    public String getDetallesDeReputacion() {
        return detallesDeReputacion;
    }

    public void setDetallesDeReputacion(String detallesDeReputacion) {
        this.detallesDeReputacion = detallesDeReputacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // Constructor vacío requerido por JPA/Hibernate
    public Voluntario() { }

    // Constructor de conveniencia para tests/DAOs/controladores
    public Voluntario(String correoElectronico, String direccion, String numeroTelefono,
                      Double reputacion, String detallesDeReputacion, Usuario usuario) {
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
        this.reputacion = reputacion;
        this.detallesDeReputacion = detallesDeReputacion;
        this.usuario = usuario;
    }
}
