package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.Veterinario;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeterinarioDAO extends GenericDAOImpl<Veterinario, Integer> {

    public VeterinarioDAO() {
        super(Veterinario.class);
    }

    private static final Logger logger = LoggerFactory.getLogger(VeterinarioDAO.class);

    public List<Veterinario> buscarPorNombre(String nombre) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Veterinario> query = session.createQuery(
                "FROM Veterinario v WHERE v.nombre LIKE :nombre", Veterinario.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.list();
        } catch (Exception e) {
            logger.error("Error al buscar veterinarios por nombre: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar veterinarios por nombre", e);
        }
    }
}
