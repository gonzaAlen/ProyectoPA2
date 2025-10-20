package ar.ugd.colonia.model;

/**
 * Familia adoptante según el diagrama.
 * Incluye contacto designado, estado y disponibilidad.
 */
public class FamiliaAdoptante extends Usuario {
    private String correoElectronicoDesignado;
    private String numeroTelefonoDesignado;
    private String direccion;
    private String estadoDeFamilia;
    private String disponibilidadDeFamilia;
    private String reputacion;
    private String detallesDeReputacion;

    public FamiliaAdoptante() { setRol("FAMILIA"); }

    public void registrarFamilia() { }
    public void eliminarFamilia(int idUsuario) { }
    public void actualizarFamilia() { }
    public FamiliaAdoptante getFamilia(int idUsuario) { return this; }
    public String mostrarReputacionFamilia(int idUsuario) { return reputacion; }

    /** Asignación será validada en capa de servicio; acá solo stub. */
    public void asignarGatoAFamilia(int idGato) { }
    /** Devuelve última visita registrada; acá placeholder. */
    public Visita getUltimaVisita() { return null; }
    public void actualizarDisponibilidad(String nuevaDisponibilidad) {
        this.disponibilidadDeFamilia = nuevaDisponibilidad;
    }

    // Getters/Setters
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
}
