package co.com.bvc.service.infrastructure.exceptions;

import co.com.bvc.service.domain.exceptions.CreatePersonException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Maneja las excepcione tanto de negocio como de infraestructura
 * @version 09/11/2021
 * @author Paola Avella
 */
@RestControllerAdvice
public class ControllerAdvice {

    /**
     * Establece el contenido de la respuesta cuando se genera una excepcion en el modelo Person
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(CreatePersonException.class)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public ErrorMessage applicationExceptionGHandler(CreatePersonException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.ACCEPTED.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }
    /**
     * Establece el contenido de la respuesta cuando se genera una excepcion en el modelo Person
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage applicationExceptionGHandler(IllegalArgumentException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }
    /**
     * Establece el contenido de la respuesta cuando se genera una excepcion en la persistencia de la infraestructura
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({PersistenceException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage infrastructureExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage nullPointerExceptionExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
               "MethodArgumentNotValidException",
                request.getDescription(false));

        return message;
    }

}