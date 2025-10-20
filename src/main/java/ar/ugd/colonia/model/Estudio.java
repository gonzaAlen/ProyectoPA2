package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Estudios subidos por el veterinario: análisis, radiografías, etc.
 * 'detalleEstudio' describe el contenido; el archivo se manejará luego.
 */
public class Estudio {
    private int idEstudio;
    private LocalDate fecha;
    private LocalTime hora;
    private String detalleEstudio;

    private Veterinario veterinario;
    private Gato gato;

    public Estudio() {}

    public void subirEstudio() { /* persistencia/archivo en otra capa */ }
    public Estudio getEstudio() { return this; }

    // Getters/Setters
    public int getIdEstudio() { return idEstudio; }
    public void setIdEstudio(int idEstudio) { this.idEstudio = idEstudio; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getDetalleEstudio() { return detalleEstudio; }
    public void setDetalleEstudio(String detalleEstudio) { this.detalleEstudio = detalleEstudio; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }
    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
}
