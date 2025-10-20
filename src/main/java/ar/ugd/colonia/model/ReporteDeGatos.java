package ar.ugd.colonia.model;

/** Reporte global: esterilizados, adoptados y en tránsito. */
public class ReporteDeGatos extends Reporte {
    private int cantidadDeGatosEsterilizados;
    private int cantidadDeGatosAdoptados;
    private int cantidadDeGatosEnTransito;

    public void generarReporteDeGatos() { /* cálculo en service */ }

    // Getters/Setters
    public int getCantidadDeGatosEsterilizados() { return cantidadDeGatosEsterilizados; }
    public void setCantidadDeGatosEsterilizados(int v) { this.cantidadDeGatosEsterilizados = v; }
    public int getCantidadDeGatosAdoptados() { return cantidadDeGatosAdoptados; }
    public void setCantidadDeGatosAdoptados(int v) { this.cantidadDeGatosAdoptados = v; }
    public int getCantidadDeGatosEnTransito() { return cantidadDeGatosEnTransito; }
    public void setCantidadDeGatosEnTransito(int v) { this.cantidadDeGatosEnTransito = v; }
}
