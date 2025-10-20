package ar.ugd.colonia.model;

/** Reporte estadístico por zona con cantidad de gatos. */
public class ReporteDeZonas extends Reporte {
    private String zona;
    private int cantidadDeGatos;

    public void generarReporteDeZonas() { /* cálculo en capa service */ }

    // Getters/Setters
    public String getZona() { return zona; }
    public void setZona(String zona) { this.zona = zona; }
    public int getCantidadDeGatos() { return cantidadDeGatos; }
    public void setCantidadDeGatos(int cantidadDeGatos) { this.cantidadDeGatos = cantidadDeGatos; }
}
