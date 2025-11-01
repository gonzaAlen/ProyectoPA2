package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.GatoDAO;
import ar.ugd.colonia.model.Gato;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GatoDAOTestJUnit {

    static GatoDAO gatoDAO;

    @BeforeAll
    public static void setup() {
        gatoDAO = new GatoDAO();
    }

    @AfterAll
    public static void tearDown() {
        // No cerramos el SessionFactory aquí porque las pruebas corren en la
        // misma JVM y cerrar el SessionFactory provoca que otras pruebas fallen
        // si intentan abrir sesiones después. El cierre se puede hacer al
        // final de toda la suite si es realmente necesario.
    }

    @Test
    public void testSaveAndFind() {
        Gato g = new Gato();
        g.setNombre("TestGato");
        g.setEdadAproximada(3);
        g.setColor("Blanco");

        gatoDAO.save(g);
        List<Gato> gatos = gatoDAO.findAll();
        assertNotNull(gatos);
        assertTrue(gatos.stream().anyMatch(x -> "TestGato".equals(x.getNombre())));

        List<Gato> encontrados = gatoDAO.buscarPorNombre("Test");
        assertNotNull(encontrados);
        assertTrue(encontrados.size() >= 1);
    }
}
