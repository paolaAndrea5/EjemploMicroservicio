package co.com.bvc.service.infrastructure.exceptions;
/**
 * Maneja las excepciones presentadas en la persistencia
 * @version 09/11/2021
 * @author Paola Avella
 */
public class PersistenceException extends RuntimeException{
    public PersistenceException(Throwable cause) {
        super(cause);
    }
}
