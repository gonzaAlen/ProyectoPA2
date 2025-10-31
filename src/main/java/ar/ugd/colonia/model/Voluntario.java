package ar.ugd.colonia.model;

import jakarta.persistence.*;

/**
 * Subclase de Usuario que representa a un voluntario.
 * Hibernate creará la tabla 'voluntario' con FK a 'usuario'.
 */
@Entity
@Table(name = "voluntario")
@PrimaryKeyJoinColumn(name = "idUsuario") // FK que enlaza con la tabla 'usuario'
public class Voluntario extends Usuario {

    @Column(length = 100)
    private String correoElectronico;

    @Column(length = 20)
    private String numeroTelefono;

    @Column(length = 120)
    private String direccion;

    @Column(length = 30)
    private String reputacion;

    @Column(length = 255)
    private String detallesDeReputacion;

    // === Constructores ===
    public Voluntario() {
        super();
        setRol("VOLUNTARIO");
    }

    public Voluntario(String nombre, String contrasena, String correoElectronico,
                      String numeroTelefono, String direccion,
                      String reputacion, String detallesDeReputacion) {
        super(nombre, contrasena, "VOLUNTARIO");
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.reputacion = reputacion;
        this.detallesDeReputacion = detallesDeReputacion;
    }

    // === Getters/Setters ===
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getReputacion() { return reputacion; }
    public void setReputacion(String reputacion) { this.reputacion = reputacion; }

    public String getDetallesDeReputacion() { return detallesDeReputacion; }
    public void setDetallesDeReputacion(String detallesDeReputacion) { this.detallesDeReputacion = detallesDeReputacion; }
}
