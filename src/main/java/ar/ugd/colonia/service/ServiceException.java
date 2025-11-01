package ar.ugd.colonia.service;

/**
 * Excepción unchecked para errores en la capa de servicios (lógica de negocio).
 * Se usa para envolver problemas provenientes de la capa DAO o validaciones.
 */
public class ServiceException extends RuntimeException {
    public ServiceException() { super(); }
    public ServiceException(String message) { super(message); }
    public ServiceException(String message, Throwable cause) { super(message, cause); }
    public ServiceException(Throwable cause) { super(cause); }
}
