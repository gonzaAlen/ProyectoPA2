package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.UsuarioDAO;
import ar.ugd.colonia.model.Usuario;
import java.util.List;

public class UsuarioDAOTest {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crear usuario de prueba
        Usuario u = new Usuario();
        u.setNombre("María López");
        u.setContrasena("m123");
        u.setRol("Administrador");
        usuarioDAO.save(u);
        System.out.println("Usuario guardado correctamente.");

        // Buscar por nombre
        Usuario encontrado = usuarioDAO.buscarPorNombre("María López");
        System.out.println("Encontrado: " + encontrado.getNombre() + " (" + encontrado.getRol() + ")");

        // Verificar autenticación
        Usuario autenticado = usuarioDAO.autenticar("María López", "m123");
        System.out.println(autenticado != null ? "Autenticación exitosa." : "Error en autenticación.");

        // Buscar por rol
        List<Usuario> admins = usuarioDAO.buscarPorRol("Administrador");
        System.out.println("Usuarios con rol Administrador:");
        for (Usuario admin : admins) {
            System.out.println("- " + admin.getNombre());
        }
    }
}
