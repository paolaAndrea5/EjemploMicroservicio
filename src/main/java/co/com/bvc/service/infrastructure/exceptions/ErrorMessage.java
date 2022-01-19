package co.com.bvc.service.infrastructure.exceptions;

import lombok.Getter;

import java.util.Date;
/**
 * Establece el contenido de la respuesta cuando se genera una excepcion
 * @version 09/11/2021
 * @author Paola Avella
 */
public class ErrorMessage {
    @Getter
    private int statusCode;

    @Getter
    private Date timestamp;

    @Getter
    private String message;

    @Getter
    private String description;

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
}
