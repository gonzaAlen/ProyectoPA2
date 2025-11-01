package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.FamiliaAdoptanteDAO;
import ar.ugd.colonia.model.FamiliaAdoptante;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FamiliaAdoptanteDAOTestJUnit {

    static FamiliaAdoptanteDAO dao;

    @BeforeAll
    public static void setup() {
        dao = new FamiliaAdoptanteDAO();
    }

    @AfterAll
    public static void tearDown() {
        // No cerramos el SessionFactory aquí por la misma razón explicada en
        // la otra prueba: dejarlo cerrado puede causar fallos en pruebas que
        // se ejecuten después en la misma JVM.
    }

    @Test
    public void testSaveAndSearch() {
        FamiliaAdoptante familia = new FamiliaAdoptante();
        familia.setNombre("Laura Gomez");
        familia.setContrasena("lg123");
        familia.setCorreoElectronicoDesignado("laura@hogarfeliz.com");
        familia.setDireccion("Posadas, Misiones");
        familia.setNumeroTelefonoDesignado("3764-555000");
        familia.setDisponibilidadDeFamilia("Alta");
        familia.setEstadoDeFamilia("Aprobada");
        familia.setReputacion("4.5");

        dao.save(familia);

        List<FamiliaAdoptante> resultados = dao.buscarPorNombre("Laura");
        assertNotNull(resultados);
        assertTrue(resultados.stream().anyMatch(f -> "Laura Gomez".equals(f.getNombre())));
    }
}
