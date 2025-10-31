package ar.ugd.colonia.repository.impl;

import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.repository.VoluntarioRepository;
import ar.ugd.colonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class VoluntarioRepositoryHibernate implements VoluntarioRepository {
    @Override
    public Voluntario save(Voluntario v) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            // si v no existe -> persist; si viene con id existente -> merge
            if (v.getIdUsuario() == null) s.persist(v); else v = (Voluntario) s.merge(v);
            tx.commit();
            return v;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Voluntario findById(Integer id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.get(Voluntario.class, id);
        }
    }

    @Override
    public List<Voluntario> findAll() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Voluntario", Voluntario.class).getResultList();
        }
    }

    @Override
    public void deleteById(Integer id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            Voluntario v = s.get(Voluntario.class, id);
            if (v != null) s.remove(v);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
