package ar.ugd.colonia.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Subclase de Usuario que representa a un veterinario.
 * Relacionado con los estudios que realiza a los gatos.
 */
@Entity
@Table(name = "veterinario")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Veterinario extends Usuario {

    @Column(length = 100)
    private String correoElectronico;

    @Column(length = 20)
    private String numeroTelefono;

    @Column(length = 120)
    private String direccion;

    private Integer matriculaProvincial;

    @Column(length = 60)
    private String especialidad;

    // === Relaciones ===
    @OneToMany(mappedBy = "veterinario", cascade = CascadeType.ALL)
    private List<Estudio> estudios;

    // === Constructores ===
    public Veterinario() {
        super();
        setRol("VETERINARIO");
    }

    public Veterinario(String nombre, String contrasena, String correoElectronico,
                       String numeroTelefono, String direccion,
                       Integer matriculaProvincial, String especialidad) {
        super(nombre, contrasena, "VETERINARIO");
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.matriculaProvincial = matriculaProvincial;
        this.especialidad = especialidad;
    }

    // === Getters/Setters ===
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String numeroTelefono) { this.numeroTelefono = numeroTelefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Integer getMatriculaProvincial() { return matriculaProvincial; }
    public void setMatriculaProvincial(Integer matriculaProvincial) { this.matriculaProvincial = matriculaProvincial; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public List<Estudio> getEstudios() { return estudios; }
    public void setEstudios(List<Estudio> estudios) { this.estudios = estudios; }
}
