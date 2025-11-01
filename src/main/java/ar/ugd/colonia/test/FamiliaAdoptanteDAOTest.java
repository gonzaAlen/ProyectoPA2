package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.FamiliaAdoptanteDAO;
import ar.ugd.colonia.model.FamiliaAdoptante;
import ar.ugd.colonia.util.HibernateUtil;

import java.util.List;

public class FamiliaAdoptanteDAOTest {

    public static void main(String[] args) {
        FamiliaAdoptanteDAO dao = new FamiliaAdoptanteDAO();

    FamiliaAdoptante familia = new FamiliaAdoptante();
    // Como FamiliaAdoptante extiende Usuario, seteamos los campos heredados directamente
    familia.setNombre("Laura Gómez");
    familia.setContrasena("lg123");
        familia.setCorreoElectronicoDesignado("laura@hogarfeliz.com");
        familia.setDireccion("Posadas, Misiones");
        familia.setNumeroTelefonoDesignado("3764-555000");
        familia.setDisponibilidadDeFamilia("Alta");
        familia.setEstadoDeFamilia("Aprobada");
        familia.setReputacion("4.5");

        dao.save(familia);
        System.out.println("Familia adoptante guardada correctamente.");

        System.out.println("Familias encontradas:");
        List<FamiliaAdoptante> resultados = dao.buscarPorNombre("Laura");
        if (resultados != null) {
            for (FamiliaAdoptante f : resultados) {
                System.out.println("- " + f.getNombre());
            }
        } else {
            System.out.println("No se encontraron familias (o ocurrió un error).");
        }

        HibernateUtil.shutdown();
    }
}
