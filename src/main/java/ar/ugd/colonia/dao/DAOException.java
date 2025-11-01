package ar.ugd.colonia.dao;

/**
 * Excepción unchecked para errores en la capa DAO.
 * Se usa para propagar fallos de persistencia hacia capas superiores.
 */
public class DAOException extends RuntimeException {

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
