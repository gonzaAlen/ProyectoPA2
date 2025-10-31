package ar.ugd.colonia.service.impl;

import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.repository.VoluntarioRepository;
import ar.ugd.colonia.repository.impl.VoluntarioRepositoryHibernate;
import ar.ugd.colonia.service.VoluntarioService;
import java.util.List;

public class VoluntarioServiceImpl implements VoluntarioService {
    private final VoluntarioRepository repo = new VoluntarioRepositoryHibernate();

    @Override public Voluntario registrar(Voluntario v) { return repo.save(v); }
    @Override public Voluntario obtener(Integer id) { return repo.findById(id); }
    @Override public List<Voluntario> listar() { return repo.findAll(); }
    @Override public void eliminar(Integer id) { repo.deleteById(id); }
}
