package ar.ugd.colonia.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class HibernateUtil {
  private static final SessionFactory SESSION_FACTORY = build();
  // Logger para registrar inicialización y errores de Hibernate
  private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

  private static SessionFactory build() {
    try {
      // Permitir cargar un archivo de configuración alternativo mediante la
      // propiedad del sistema 'hibernate.config' (por ejemplo 'hibernate-test.cfg.xml')
      String cfg = System.getProperty("hibernate.config");
      if (cfg != null && !cfg.isEmpty()) {
        return new Configuration().configure(cfg).buildSessionFactory();
      }
      return new Configuration().configure().buildSessionFactory();
    } catch (Exception e) {
      // Registramos el error y lanzamos para detener la inicialización
      logger.error("ERROR al iniciar Hibernate: {}", e.getMessage(), e);
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
