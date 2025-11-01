package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.Gato;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO específico para la entidad Gato.
 * Hereda las operaciones básicas de GenericDAOImpl y puede incluir consultas personalizadas.
 */
public class GatoDAO extends GenericDAOImpl<Gato, Integer> {

    public GatoDAO() {
        super(Gato.class);
    }

    private static final Logger logger = LoggerFactory.getLogger(GatoDAO.class);

    /**
     * Ejemplo de consulta personalizada:
     * Busca gatos por nombre (coincidencia parcial).
     */
    public List<Gato> buscarPorNombre(String nombre) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Gato> query = session.createQuery(
                "FROM Gato g WHERE g.nombre LIKE :nombre", Gato.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.list();
        } catch (Exception e) {
            logger.error("Error al buscar gatos por nombre: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar gatos por nombre", e);
        }
    }
}
