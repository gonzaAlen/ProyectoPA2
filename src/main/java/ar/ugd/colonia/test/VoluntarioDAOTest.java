package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.VoluntarioDAO;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.model.Usuario;

import java.util.List;

public class VoluntarioDAOTest {

    public static void main(String[] args) {
        VoluntarioDAO voluntarioDAO = new VoluntarioDAO();

        // Crear usuario asociado
        Usuario u = new Usuario();
        u.setNombre("Carlos Pérez");
        u.setContrasena("1234");
        u.setRol("Voluntario");

        // Crear voluntario
        Voluntario v = new Voluntario();
        v.setUsuario(u);
        v.setCorreoElectronico("carlos@colonia.org");
        v.setDireccion("Calle 9 N°120");
        v.setNumeroTelefono("3764001122");
        v.setReputacion(5.0);
        v.setDetallesDeReputacion("Excelente compromiso");

        // Guardar
        voluntarioDAO.save(v);
        System.out.println("Voluntario guardado correctamente.");

        // Consultar todos
        List<Voluntario> lista = voluntarioDAO.findAll();
        System.out.println("Voluntarios registrados:");
        for (Voluntario vol : lista) {
            System.out.println("- " + vol.getUsuario().getNombre() + " (" + vol.getCorreoElectronico() + ")");
        }

        // Buscar por nombre
        List<Voluntario> encontrados = voluntarioDAO.buscarPorNombre("Car");
        System.out.println("Resultados de búsqueda:");
        for (Voluntario vol : encontrados) {
            System.out.println("- " + vol.getUsuario().getNombre());
        }
    }
}
