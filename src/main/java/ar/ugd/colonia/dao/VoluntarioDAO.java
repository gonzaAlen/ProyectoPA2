package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.Voluntario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO para la entidad Voluntario.
 * Gestiona operaciones CRUD y consultas personalizadas sobre voluntarios.
 */
public class VoluntarioDAO extends GenericDAOImpl<Voluntario, Integer> {

    // Logger para esta clase DAO
    private static final Logger logger = LoggerFactory.getLogger(VoluntarioDAO.class);

    public VoluntarioDAO() {
        super(Voluntario.class);
    }

    /**
     * Busca voluntarios por nombre (coincidencia parcial).
     */
    public List<Voluntario> buscarPorNombre(String nombre) {
        // Busca voluntarios cuyo nombre de usuario contiene el texto dado.
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Voluntario> query = session.createQuery(
                "FROM Voluntario v WHERE v.usuario.nombre LIKE :nombre", Voluntario.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.list();
        } catch (Exception e) {
            logger.error("Error al buscar voluntarios por nombre: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar voluntarios por nombre", e);
        }
    }

}
