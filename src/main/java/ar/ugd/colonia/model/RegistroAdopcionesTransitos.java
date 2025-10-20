package ar.ugd.colonia.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Registro de adopciones o tránsitos para un gato con una familia.
 */
public class RegistroAdopcionesTransitos {
    private int idRegistro;
    private String tipo;          // ADOPCION o TRANSITO
    private LocalDate fecha;
    private LocalTime hora;

    private Gato gato;
    private FamiliaAdoptante familia;

    public RegistroAdopcionesTransitos() {}

    public void agregarRegistro() { /* persistencia en DAO */ }
    public RegistroAdopcionesTransitos getRegistro() { return this; }

    // Getters/Setters
    public int getIdRegistro() { return idRegistro; }
    public void setIdRegistro(int idRegistro) { this.idRegistro = idRegistro; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }
    public Gato getGato() { return gato; }
    public void setGato(Gato gato) { this.gato = gato; }
    public FamiliaAdoptante getFamilia() { return familia; }
    public void setFamilia(FamiliaAdoptante familia) { this.familia = familia; }
}
