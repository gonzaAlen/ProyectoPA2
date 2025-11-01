package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.UsuarioDAO;
import ar.ugd.colonia.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas JUnit para UsuarioDAO usando H2 en memoria.
 */
public class UsuarioDAOTestJUnit {

    static UsuarioDAO dao;

    @BeforeAll
    public static void setup() {
        dao = new UsuarioDAO();
    }

    @Test
    public void testSaveAndAuthAndRoleSearch() {
        Usuario u = new Usuario();
        u.setNombre("María López");
        u.setContrasena("m123");
        u.setRol("Administrador");

        dao.save(u);

        // Buscar por nombre
        Usuario encontrado = dao.buscarPorNombre("María López");
        assertNotNull(encontrado, "Debe encontrar el usuario por nombre");

        // Autenticación
        Usuario auth = dao.autenticar("María López", "m123");
        assertNotNull(auth, "La autenticación debe ser exitosa con credenciales correctas");

        // Buscar por rol
        List<Usuario> admins = dao.buscarPorRol("Administrador");
        assertNotNull(admins);
        assertTrue(admins.size() >= 1, "Debe haber al menos un administrador");
    }
}
