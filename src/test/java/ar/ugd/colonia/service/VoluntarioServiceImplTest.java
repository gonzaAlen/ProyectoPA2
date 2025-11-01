package ar.ugd.colonia.service;

import ar.ugd.colonia.dao.DAOException;
import ar.ugd.colonia.dao.VoluntarioRepository;
import ar.ugd.colonia.model.Voluntario;
import ar.ugd.colonia.service.impl.VoluntarioServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests unitarios simples para verificar la conversión de DAOException -> ServiceException
 * en VoluntarioServiceImpl. No dependemos de Hibernate aquí: inyectamos un repo falso.
 */
public class VoluntarioServiceImplTest {

    static class FailingRepo implements VoluntarioRepository {
        private final DAOException ex = new DAOException("simulated dao failure");

        @Override
        public Voluntario save(Voluntario entity) {
            throw ex;
        }

        @Override
        public Voluntario findById(Integer id) {
            throw ex;
        }

        @Override
        public List<Voluntario> findAll() {
            throw ex;
        }

        @Override
        public void deleteById(Integer id) {
            throw ex;
        }
    }

    @Test
    public void registrar_whenDaoThrows_thenServiceException() {
        VoluntarioServiceImpl svc = new VoluntarioServiceImpl(new FailingRepo());
        Assertions.assertThrows(ServiceException.class, () -> svc.registrar(new Voluntario()));
    }

    @Test
    public void obtener_whenDaoThrows_thenServiceException() {
        VoluntarioServiceImpl svc = new VoluntarioServiceImpl(new FailingRepo());
        Assertions.assertThrows(ServiceException.class, () -> svc.obtener(1));
    }

    @Test
    public void listar_whenDaoThrows_thenServiceException() {
        VoluntarioServiceImpl svc = new VoluntarioServiceImpl(new FailingRepo());
        Assertions.assertThrows(ServiceException.class, () -> svc.listar());
    }

    @Test
    public void eliminar_whenDaoThrows_thenServiceException() {
        VoluntarioServiceImpl svc = new VoluntarioServiceImpl(new FailingRepo());
        Assertions.assertThrows(ServiceException.class, () -> svc.eliminar(1));
    }
}
