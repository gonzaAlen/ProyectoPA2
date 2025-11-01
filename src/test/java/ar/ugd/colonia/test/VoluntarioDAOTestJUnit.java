package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.VoluntarioDAO;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas JUnit para VoluntarioDAO usando H2 en memoria.
 * Comentarios en español para facilitar la lectura.
 */
public class VoluntarioDAOTestJUnit {

    static VoluntarioDAO dao;

    @BeforeAll
    public static void setup() {
        // Creamos la instancia del DAO; Hibernate se configura vía -Dhibernate.config
        dao = new VoluntarioDAO();
    }

    @Test
    public void testSaveAndFind() {
        // Crear usuario asociado
        Usuario u = new Usuario();
        u.setNombre("Carlos Pérez");
        u.setContrasena("1234");
        u.setRol("Voluntario");

        // Crear voluntario y asociar usuario
        Voluntario v = new Voluntario();
        v.setUsuario(u);
        v.setCorreoElectronico("carlos@colonia.org");
        v.setDireccion("Calle 9 N°120");
        v.setNumeroTelefono("3764001122");
        v.setReputacion(5.0);
        v.setDetallesDeReputacion("Excelente compromiso");

        dao.save(v);

        // Verificar que aparece en la lista general
        List<Voluntario> lista = dao.findAll();
        assertNotNull(lista, "La lista de voluntarios no debe ser nula");
        assertTrue(lista.stream().anyMatch(vol -> "Carlos Pérez".equals(vol.getUsuario().getNombre())),
                "Debe existir el voluntario guardado");

        // Buscar por nombre parcial
        List<Voluntario> encontrados = dao.buscarPorNombre("Car");
        assertNotNull(encontrados);
        assertTrue(encontrados.size() >= 1);
    }
}
