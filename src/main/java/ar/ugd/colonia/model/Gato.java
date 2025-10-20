package ar.ugd.colonia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Núcleo del dominio. Contiene datos del gato y operaciones del diagrama.
 * Las operaciones de listar/eliminar se implementarán realmente en Repository/Service.
 */
public class Gato {
    // Atributos del diagrama
    private int idGato;
    private String nombre;               // opcional
    private String color;
    private String caracteristicas;
    private String foto;                 // ruta o url
    private String estadoDeSalud;        // luego será enum
    private int edadAproximada;
    private String codigoQR;

    // Constructores
    public Gato() {}
    public Gato(int idGato, String nombre, String color, String caracteristicas,
                String estadoDeSalud, int edadAproximada, String foto, String codigoQR) {
        this.idGato = idGato;
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.estadoDeSalud = estadoDeSalud;
        this.edadAproximada = edadAproximada;
        this.foto = foto;
        this.codigoQR = codigoQR;
    }

    // Operaciones del diagrama (stubs)
    public void registrarGato(String nombre, String color, String caracteristicas,
                              String estadoDeSalud, int edadAproximada, String zona,
                              String foto, String codigoQR) {
        // seteo básico; persistencia real en capa DAO/Service
        this.nombre = nombre;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.estadoDeSalud = estadoDeSalud;
        this.edadAproximada = edadAproximada;
        this.foto = foto;
        this.codigoQR = codigoQR;
        // zona se manejará como relación cuando definamos la clase Zona.
    }
    public void eliminarGato(int idGato) { /* borrar en persistencia */ }
    public void actualizarEstadoDeSalud(String nuevoEstado) { this.estadoDeSalud = nuevoEstado; }
    public Gato getGato() { return this; }
    public List<Gato> listarGatos() { return new ArrayList<>(); }
    public List<Gato> listarGatosAsignados() { return new ArrayList<>(); }
    public int getIdGato() { return idGato; }

    // Getters/Setters básicos
    public void setIdGato(int idGato) { this.idGato = idGato; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getCaracteristicas() { return caracteristicas; }
    public void setCaracteristicas(String v) { this.caracteristicas = v; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
    public String getEstadoDeSalud() { return estadoDeSalud; }
    public void setEstadoDeSalud(String v) { this.estadoDeSalud = v; }
    public int getEdadAproximada() { return edadAproximada; }
    public void setEdadAproximada(int v) { this.edadAproximada = v; }
    public String getCodigoQR() { return codigoQR; }
    public void setCodigoQR(String v) { this.codigoQR = v; }
}
