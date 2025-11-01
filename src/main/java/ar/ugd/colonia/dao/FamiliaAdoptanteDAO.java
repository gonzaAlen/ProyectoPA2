package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.FamiliaAdoptante;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO para la entidad FamiliaAdoptante.
 */
public class FamiliaAdoptanteDAO extends GenericDAOImpl<FamiliaAdoptante, Integer> {

    private static final Logger logger = LoggerFactory.getLogger(FamiliaAdoptanteDAO.class);

    public FamiliaAdoptanteDAO() {
        super(FamiliaAdoptante.class);
    }

    /**
     * Busca familias por nombre de usuario asociado (coincidencia parcial).
     */
    public List<FamiliaAdoptante> buscarPorNombre(String nombre) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<FamiliaAdoptante> query = session.createQuery(
                "FROM FamiliaAdoptante f WHERE f.nombre LIKE :nombre", 
                FamiliaAdoptante.class
            );
            query.setParameter("nombre", "%" + nombre + "%");
            return query.list();
        } catch (Exception e) {
            logger.error("Error al buscar familia adoptante: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar familia adoptante", e);
        }
    }
}
