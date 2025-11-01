package ar.ugd.colonia.dao.impl;

import ar.ugd.colonia.dao.VoluntarioRepository;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class VoluntarioRepositoryHibernate implements VoluntarioRepository {
    @Override
    public Voluntario save(Voluntario v) {
        Transaction tx = null;
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            tx = s.beginTransaction();
            // si v no existe -> persist; si viene con id existente -> merge
            if (v.getIdUsuario() == null) s.persist(v); else v = (Voluntario) s.merge(v);
            tx.commit();
            return v;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            // envolver en DAOException para que la capa superior lo maneje
            throw new ar.ugd.colonia.dao.DAOException("Error al guardar Voluntario", e);
        } finally {
            if (s != null && s.isOpen()) s.close();
        }
    }

    @Override
    public Voluntario findById(Integer id) {
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            return s.get(Voluntario.class, id);
        } catch (Exception e) {
            throw new ar.ugd.colonia.dao.DAOException("Error al buscar Voluntario por id", e);
        } finally {
            if (s != null && s.isOpen()) s.close();
        }
    }

    @Override
    public List<Voluntario> findAll() {
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            return s.createQuery("from Voluntario", Voluntario.class).getResultList();
        } catch (Exception e) {
            throw new ar.ugd.colonia.dao.DAOException("Error al listar Voluntarios", e);
        } finally {
            if (s != null && s.isOpen()) s.close();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Transaction tx = null;
        Session s = null;
        try {
            s = HibernateUtil.getSessionFactory().openSession();
            tx = s.beginTransaction();
            Voluntario v = s.get(Voluntario.class, id);
            if (v != null) s.remove(v);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new ar.ugd.colonia.dao.DAOException("Error al eliminar Voluntario", e);
        } finally {
            if (s != null && s.isOpen()) s.close();
        }
    }
}
