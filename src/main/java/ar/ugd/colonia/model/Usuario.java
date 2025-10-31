package ar.ugd.colonia.model;

import jakarta.persistence.*;

/**
 * Clase base para todos los tipos de usuario.
 * Hibernate creará una tabla 'usuario' y permitirá heredar columnas en subclases.
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED) // cada subclase tendrá su propia tabla con FK al usuario
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(length = 80, nullable = false)
    private String nombre;

    @Column(length = 120, nullable = false)
    private String contrasena;

    @Column(length = 20, nullable = false)
    private String rol;

    // === Constructores ===
    public Usuario() {}

    public Usuario(String nombre, String contrasena, String rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // === Getters/Setters ===
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
