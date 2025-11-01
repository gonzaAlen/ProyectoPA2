package ar.ugd.colonia.dao;

import ar.ugd.colonia.model.Gato;
import ar.ugd.colonia.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Verifica que una transacción que se revierte no persiste cambios en la base H2.
 */
public class TransactionRollbackTest {

    @Test
    public void whenTransactionRolledBack_thenNoEntityPersisted() {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            Gato g = new Gato("RollbackCat", "negro", "test", "bueno", 2, null, "QR-ROLLBACK-1");
            session.persist(g);

            // Forzamos una excepción antes de commitear para provocar rollback
            throw new RuntimeException("Force rollback");

        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            if (session != null && session.isOpen()) session.close();
        }

        // Abrimos otra sesión para comprobar que no existe ningún gato con ese codigoQR
        try (Session s2 = HibernateUtil.getSessionFactory().openSession()) {
            Long count = s2.createQuery("select count(g) from Gato g where g.codigoQR = :qr", Long.class)
                    .setParameter("qr", "QR-ROLLBACK-1")
                    .uniqueResult();
            Assertions.assertNotNull(count);
            Assertions.assertEquals(0L, count.longValue(), "La entidad no debe haberse persistido tras rollback");
        }
    }
}
