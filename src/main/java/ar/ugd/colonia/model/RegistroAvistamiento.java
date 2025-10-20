package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Avistamiento de un gato en la vía pública con ubicación y notas.
 */
public class RegistroAvistamiento {
    private int idAvistamiento;
    private LocalDate fecha;
    private LocalTime hora;
    private String color;
    private String tamano;
    private String observaciones;
    private String coordenadas;   // lat,long en texto

    private Voluntario voluntario;

    public RegistroAvistamiento() {}

    public void crearAvistamiento() { /* persistencia */ }
    public RegistroAvistamiento getAvistamiento() { return this; }

    // Getters/Setters
    public int getIdAvistamiento() { return idAvistamiento; }
    public void setIdAvistamiento(int idAvistamiento) { this.idAvistamiento = idAvistamiento; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getTamano() { return tamano; }
    public void setTamano(String tamano) { this.tamano = tamano; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public String getCoordenadas() { return coordenadas; }
    public void setCoordenadas(String coordenadas) { this.coordenadas = coordenadas; }
    public Voluntario getVoluntario() { return voluntario; }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }
}
