package ar.ugd.colonia.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
  private static final SessionFactory SESSION_FACTORY = build();

  private static SessionFactory build() {
    try {
      return new Configuration().configure().buildSessionFactory();
    } catch (Exception e) {
      System.err.println("ERROR al iniciar Hibernate: " + e.getMessage());
      e.printStackTrace();
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
