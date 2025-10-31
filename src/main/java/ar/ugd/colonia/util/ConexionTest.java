package ar.ugd.colonia.util;

import org.hibernate.Session;

public class ConexionTest {
  public static void main(String[] args) {
    try (Session s = HibernateUtil.getSessionFactory().openSession()) {
      System.out.println("OK: Conexión a MySQL establecida.");
    } finally {
      HibernateUtil.shutdown();
    }
  }
}
