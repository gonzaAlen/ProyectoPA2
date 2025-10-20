package ar.ugd.colonia.model;

import java.time.LocalDate;

/**
 * Visita de seguimiento a una familia adoptante o de tránsito.
 */
public class Visita {
    private int idVisita;
    private LocalDate fecha;
    private String estadoGato;      // estado observado durante la visita
    private String observaciones;
    private String sugerencias;

    private FamiliaAdoptante familia;  // referencia lógica

    public Visita() {}

    public void registrarVisita() { /* persistencia en DAO */ }
    /** Devuelve la propia instancia como stub del diagrama. */
    public Visita ultimaVisita() { return this; }
    /** En repositorio devolverá una lista; aquí solo stub. */
    public java.util.List<Visita> listarVisitas() { return java.util.List.of(this); }

    // Getters/Setters
    public int getIdVisita() { return idVisita; }
    public void setIdVisita(int idVisita) { this.idVisita = idVisita; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getEstadoGato() { return estadoGato; }
    public void setEstadoGato(String estadoGato) { this.estadoGato = estadoGato; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public String getSugerencias() { return sugerencias; }
    public void setSugerencias(String sugerencias) { this.sugerencias = sugerencias; }
    public FamiliaAdoptante getFamilia() { return familia; }
    public void setFamilia(FamiliaAdoptante familia) { this.familia = familia; }
}
