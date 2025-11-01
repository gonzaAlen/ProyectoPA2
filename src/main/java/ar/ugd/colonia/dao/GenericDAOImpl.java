package ar.ugd.colonia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.ugd.colonia.util.HibernateUtil;

/**
 * Implementación genérica de la interfaz GenericDAO<T,ID>.
 * Gestiona las operaciones básicas con Hibernate.
 */
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private final Class<T> entityClass;
    // Logger: registra mensajes de aplicación y errores.
    private static final Logger logger = LoggerFactory.getLogger(GenericDAOImpl.class);

    /**
     * Constructor: requiere el tipo de clase (por ejemplo, Gato.class)
     */
    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (Exception e) {
            try {
                if (tx != null) tx.rollback();
            } catch (Exception ex) {
                // Si falla el rollback lo registramos; no queremos ocultar la excepción original
                logger.error("Error al hacer rollback al guardar {}: {}", entityClass.getSimpleName(), ex.getMessage(), ex);
            }
            // Lanzamos una excepción específica de DAO para que la capa superior la maneje
            throw new DAOException("Error al guardar " + entityClass.getSimpleName(), e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public T findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        } catch (Exception e) {
            // Lanzar DAOException para que la capa superior decida cómo manejar el error
            throw new DAOException("Error al buscar " + entityClass.getSimpleName() + " por ID", e);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM " + entityClass.getSimpleName();
            Query<T> query = session.createQuery(hql, entityClass);
            return query.list();
        } catch (Exception e) {
            throw new DAOException("Error al listar " + entityClass.getSimpleName(), e);
        }
    }

    @Override
    public void update(T entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        } catch (Exception e) {
            try {
                if (tx != null) tx.rollback();
            } catch (Exception ex) {
                logger.error("Error al hacer rollback al actualizar {}: {}", entityClass.getSimpleName(), ex.getMessage(), ex);
            }
            throw new DAOException("Error al actualizar " + entityClass.getSimpleName(), e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T entity) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        } catch (Exception e) {
            try {
                if (tx != null) tx.rollback();
            } catch (Exception ex) {
                logger.error("Error al hacer rollback al eliminar {}: {}", entityClass.getSimpleName(), ex.getMessage(), ex);
            }
            throw new DAOException("Error al eliminar " + entityClass.getSimpleName(), e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
