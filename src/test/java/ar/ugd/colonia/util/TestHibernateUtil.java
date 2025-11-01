package ar.ugd.colonia.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utilidad de Hibernate para pruebas. Carga `hibernate-test.cfg.xml`.
 *
 * Comentario: mantenemos una clase separada para pruebas por si en el futuro
 * queremos comportamientos distintos (por ejemplo, diferentes propiedades).
 */
public final class TestHibernateUtil {
  private static final SessionFactory SESSION_FACTORY = build();
  private static final Logger logger = LoggerFactory.getLogger(TestHibernateUtil.class);

  private static SessionFactory build() {
    try {
      // Carga explícita del archivo de configuración de pruebas (H2 in-memory)
      return new Configuration().configure("hibernate-test.cfg.xml").buildSessionFactory();
    } catch (Exception e) {
      // Registrar el error para facilitar el diagnóstico en los tests
      logger.error("ERROR al iniciar Hibernate (test): {}", e.getMessage(), e);
      throw new ExceptionInInitializerError(e);
    }
  }

  public static SessionFactory getSessionFactory() {
    return SESSION_FACTORY;
  }

  public static void shutdown() {
    getSessionFactory().close();
  }
}
