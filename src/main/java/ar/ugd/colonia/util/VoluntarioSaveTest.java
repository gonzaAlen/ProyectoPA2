package ar.ugd.colonia.util;

import ar.ugd.colonia.model.Usuario;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.service.VoluntarioService;
import ar.ugd.colonia.service.impl.VoluntarioServiceImpl;

public class VoluntarioSaveTest {
  public static void main(String[] args){
    VoluntarioService svc = new VoluntarioServiceImpl();

    // Crear Usuario y Voluntario usando setters para mantener coherencia con las entidades JPA
    Usuario u = new Usuario("Ana", "secreta123", "VOLUNTARIO");

    Voluntario v = new Voluntario();
    v.setUsuario(u);
    v.setCorreoElectronico("ana@mail.com");
    v.setNumeroTelefono("3764000000");
    v.setDireccion("Mitre 123");
    // reputacion se deja nula; usamos detalles para almacenar el nivel y nota
    v.setReputacion(null);
    v.setDetallesDeReputacion("ALTA - Colabora desde 2023");

    svc.registrar(v);
    System.out.println("Voluntario id=" + v.getIdUsuario());
    System.out.println("Total=" + svc.listar().size());
    HibernateUtil.shutdown();
  }
}
