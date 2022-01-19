package co.com.bvc.service.domain.exceptions;

/**
 * Maneja las excepciones presentadas en la entidad de negocio persona
 * @version 09/11/2021
 * @author Paola Avella
 **/
public class CreatePersonException extends RuntimeException {
    public CreatePersonException(String message) {
        super(message);
    }
}
