package ar.ugd.colonia.service.impl;

import ar.ugd.colonia.dao.VoluntarioRepository;
import ar.ugd.colonia.dao.impl.VoluntarioRepositoryHibernate;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.service.VoluntarioService;
import ar.ugd.colonia.service.ServiceException;
import ar.ugd.colonia.dao.DAOException;
import java.util.List;

/**
 * Implementación del servicio de Voluntario.
 * Atrapa errores de la capa DAO (DAOException) y los envuelve en ServiceException
 * para que la capa superior (por ejemplo controlador/UI) los maneje de forma
 * adecuada.
 */
public class VoluntarioServiceImpl implements VoluntarioService {
    private final VoluntarioRepository repo;

    /** Constructor por defecto que usa la implementación Hibernate. */
    public VoluntarioServiceImpl() {
        this(new VoluntarioRepositoryHibernate());
    }

    /** Constructor para inyección de dependencias (útil en tests). */
    public VoluntarioServiceImpl(VoluntarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public Voluntario registrar(Voluntario v) {
        try {
            // Aquí podríamos añadir validaciones de negocio (email, teléfono, etc.)
            return repo.save(v);
        } catch (DAOException e) {
            // Convertimos la excepción de persistencia en una de servicio
            throw new ServiceException("No se pudo registrar el voluntario", e);
        }
    }

    @Override
    public Voluntario obtener(Integer id) {
        try {
            return repo.findById(id);
        } catch (DAOException e) {
            throw new ServiceException("No se pudo obtener el voluntario", e);
        }
    }

    @Override
    public List<Voluntario> listar() {
        try {
            return repo.findAll();
        } catch (DAOException e) {
            throw new ServiceException("No se pudo listar los voluntarios", e);
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            repo.deleteById(id);
        } catch (DAOException e) {
            throw new ServiceException("No se pudo eliminar el voluntario", e);
        }
    }
}
