package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.Usuario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO específico para la entidad Usuario.
 * Permite gestionar operaciones CRUD y consultas de autenticación.
 */
public class UsuarioDAO extends GenericDAOImpl<Usuario, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAO.class);

    public UsuarioDAO() {
        super(Usuario.class);
    }

    /**
     * Busca un usuario por nombre exacto.
     */
    public Usuario buscarPorNombre(String nombre) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery(
                "FROM Usuario u WHERE u.nombre = :nombre", Usuario.class);
            query.setParameter("nombre", nombre);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error("Error al buscar usuario: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar usuario", e);
        }
    }

    /**
     * Verifica si las credenciales (nombre, contraseña) son correctas.
     * Retorna el usuario si coincide, o null si no existe.
     */
    public Usuario autenticar(String nombre, String contrasena) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery(
                "FROM Usuario u WHERE u.nombre = :nombre AND u.contrasena = :contrasena", Usuario.class);
            query.setParameter("nombre", nombre);
            query.setParameter("contrasena", contrasena);
            return query.uniqueResult();
        } catch (Exception e) {
            logger.error("Error al autenticar usuario: {}", e.getMessage(), e);
            throw new DAOException("Error al autenticar usuario", e);
        }
    }

    /**
     * Obtiene todos los usuarios de un rol específico.
     */
    public List<Usuario> buscarPorRol(String rol) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Usuario> query = session.createQuery(
                "FROM Usuario u WHERE u.rol = :rol", Usuario.class);
            query.setParameter("rol", rol);
            return query.list();
        } catch (Exception e) {
            logger.error("Error al buscar usuarios por rol: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar usuarios por rol", e);
        }
    }
}
