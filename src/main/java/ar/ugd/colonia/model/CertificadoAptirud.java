package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Certificado de aptitud para adopción emitido por el veterinario.
 */
public class CertificadoAptitud {
    private int idCertificadoDeAdopcion;
    private LocalDate fecha;
    private LocalTime hora;
    private String detalleDiagnostico;

    private Veterinario veterinario;
    private Gato gato;

    public CertificadoAptitud() {}

    public void emitirCertificado() { /* generar/firmar en otra capa */ }
    public CertificadoAptitud getCertificado() { return this; }

    // Getters/Setters
    public int getIdCertificadoDeAdopcion() { return idCertificadoDeAdopcion; }
    public void setIdCertificadoDeAdopcion(int id) { this.idCertificadoDeAdopcion = id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getDetalleDiagnostico() { return detalleDiagnostico; }
    public void setDetalleDiagnostico(String detalleDiagnostico) { this.detalleDiagnostico = detalleDiagnostico; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }
    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
