package ar.ugd.colonia.service;
import ar.ugd.colonia.model.Voluntario;
import java.util.List;

public interface VoluntarioService {
    Voluntario registrar(Voluntario v);
    Voluntario obtener(Integer id);
    List<Voluntario> listar();
    void eliminar(Integer id);
}
