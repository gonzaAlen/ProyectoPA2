/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.ugd.colonia.model;

/**
 *
 * @author Gonza
 */
public class Usuario {
    // Atributos del diagrama 
    private int idUsuario;
    private String nombre;
    private String contrasena;
    private String rol; // por ahora texto; más adelante puede ser que usemos enum

    // Constructores 
    public Usuario() {}
    public Usuario(int idUsuario, String nombre, String contrasena, String rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Métodos del diagrama (stubs)
    //Inicia sesión validando credenciales. Aquí solo es un stub. 
    public boolean iniciarSesion(int idUsuario, String contrasena) {
        return this.idUsuario == idUsuario && Objects.equals(this.contrasena, contrasena);
    }
    // Cierra sesión. En POO simple no hace nada; se completa en capa de control.
    public void cerrarSesion() {  }
    
    // Devuelve una referencia a sí mismo (con el metodo getUsuario). 
    public Usuario getUsuario() { return this; }

    // === Getters/Setters ===
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol;}
}
