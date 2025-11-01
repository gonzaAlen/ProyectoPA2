package ar.ugd.colonia.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interfaz genérica para definir las operaciones básicas de persistencia.
 * @param <T> tipo de la entidad gestionada
 * @param <ID> tipo del identificador (por ejemplo Integer, Long)
 */
public interface GenericDAO<T, ID extends Serializable> {

    /**
     * Guarda una nueva entidad en la base de datos.
     */
    void save(T entity);

    /**
     * Busca una entidad por su ID.
     * @param id identificador único
     * @return entidad encontrada o null
     */
    T findById(ID id);

    /**
     * Obtiene todas las entidades del tipo T.
     */
    List<T> findAll();

    /**
     * Actualiza una entidad existente.
     */
    void update(T entity);

    /**
     * Elimina una entidad.
     */
    void delete(T entity);
}
