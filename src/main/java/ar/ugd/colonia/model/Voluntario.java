package ar.ugd.colonia.model;

/**
 * Especialización de Usuario según el diagrama.
 * Aporta contacto y reputación del voluntario.
 */
public class Voluntario extends Usuario {
    private String correoElectronico;
    private String numeroTelefono;
    private String direccion;
    private String reputacion;
    private String detallesDeReputacion;

    public Voluntario() { setRol("VOLUNTARIO"); }

    // Operaciones del diagrama (stubs; la lógica real irá en Service/DAO)
    public void registrarVoluntario() { /* crear en persistencia */ }
    public void eliminarVoluntario(int idUsuario) { /* borrar en persistencia */ }
    public void actualizarVoluntario() { /* update en persistencia */ }
    public Voluntario getVoluntario(int idUsuario) { return this; }
    public String mostrarReputacionVoluntario(int idUsuario) { return reputacion; }

    // Getters/Setters
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String v) { this.correoElectronico = v; }
    public String getNumeroTelefono() { return numeroTelefono; }
    public void setNumeroTelefono(String v) { this.numeroTelefono = v; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String v) { this.direccion = v; }
    public String getReputacion() { return reputacion; }
    public void setReputacion(String v) { this.reputacion = v; }
    public String getDetallesDeReputacion() { return detallesDeReputacion; }
    public void setDetallesDeReputacion(String v) { this.detallesDeReputacion = v; }
}
