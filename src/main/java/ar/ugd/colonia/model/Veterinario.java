package ar.ugd.colonia.model;

/** Especialización de Usuario con matrícula y especialidad. */
public class Veterinario extends Usuario {
    private String correoElectronico;
    private String numeroTelefono;
    private String direccion;
    private int matriculaProvincial;
    private String especialidad;

    public Veterinario() { setRol("VETERINARIO"); }

    public void registrarVeterinario() { }
    public void eliminarVeterinario(int idUsuario) { }
    public void actualizarVeterinario() { }
    public Veterinario getVeterinario(int idUsuario) { return this; }

    // Getters/Setters
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String v) { this.correoElectronico = v; }
    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String v) { this.numeroTelefono = v; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String v) { this.direccion = v; }
    public int getMatriculaProvincial() { return matriculaProvincial; }
    public void setMatriculaProvincial(int v) { this.matriculaProvincial = v; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String v) { this.especialidad = v; }
}
