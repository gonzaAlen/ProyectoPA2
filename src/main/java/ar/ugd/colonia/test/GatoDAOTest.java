package ar.ugd.colonia.test;

import ar.ugd.colonia.dao.GatoDAO;
import ar.ugd.colonia.model.Gato;

import java.util.List;

public class GatoDAOTest {

    public static void main(String[] args) {
        GatoDAO gatoDAO = new GatoDAO();

        // Crear un nuevo gato
        Gato g = new Gato();
        g.setNombre("Luna");
        g.setEdadAproximada(2);
        g.setColor("Negro");

        gatoDAO.save(g);
        System.out.println("Gato guardado correctamente.");

        // Consultar todos los gatos
        List<Gato> gatos = gatoDAO.findAll();
        System.out.println("Lista de gatos registrados:");
        for (Gato gato : gatos) {
            System.out.println("- " + gato.getNombre() + " (" + gato.getColor() + ")");
        }

        // Buscar por nombre
        List<Gato> encontrados = gatoDAO.buscarPorNombre("Lu");
        System.out.println("Resultados de búsqueda por 'Lu':");
        for (Gato gato : encontrados) {
            System.out.println("- " + gato.getNombre());
        }
    }
}
