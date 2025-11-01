package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.Administrador;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdministradorDAO extends GenericDAOImpl<Administrador, Integer> {

    public AdministradorDAO() {
        super(Administrador.class);
    }

    private static final Logger logger = LoggerFactory.getLogger(AdministradorDAO.class);

    public List<Administrador> buscarPorNombre(String nombre) {
        try (Session session = ar.ugd.colonia.util.HibernateUtil.getSessionFactory().openSession()) {
            Query<Administrador> query = session.createQuery(
                "FROM Administrador a WHERE a.nombre LIKE :nombre", Administrador.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.list();
        } catch (Exception e) {
            logger.error("Error al buscar administradores por nombre: {}", e.getMessage(), e);
            throw new DAOException("Error al buscar administradores por nombre", e);
        }
    }
}
