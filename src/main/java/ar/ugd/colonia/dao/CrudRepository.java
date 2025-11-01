package ar.ugd.colonia.dao;
import java.util.List;

public interface CrudRepository<T, ID> {
    T save(T e);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
