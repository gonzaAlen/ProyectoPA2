package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Diagnóstico y tratamiento emitido por un veterinario para un gato.
 */
public class DiagnosticoYTratamiento {
    private int idDiagnostico;
    private LocalDate fecha;
    private LocalTime hora;
    private String detalleDiagnostico;
    private String detalleTratamiento;

    private Veterinario veterinario;
    private Gato gato;

    public DiagnosticoYTratamiento() {}

    public void agregarDiagnostico() { /* persistencia en DAO */ }
    public DiagnosticoYTratamiento getDiagnostico() { return this; }

    // Getters/Setters
    public int getIdDiagnostico() { return idDiagnostico; }
    public void setIdDiagnostico(int idDiagnostico) { this.idDiagnostico = idDiagnostico; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getDetalleDiagnostico() { return detalleDiagnostico; }
    public void setDetalleDiagnostico(String detalleDiagnostico) { this.detalleDiagnostico = detalleDiagnostico; }
    public String getDetalleTratamiento() { return detalleTratamiento; }
    public void setDetalleTratamiento(String detalleTratamiento) { this.detalleTratamiento = detalleTratamiento; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }
    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
