package co.com.bvc.service.domain.model;
import co.com.bvc.service.domain.exceptions.CreatePersonException;
import lombok.Data;
/**
 * Entidad de negocio para manejar la logica de negocio de una Persona
 * @version 09/11/2021
 * @author Paola Avella
 **/
@Data
public class Person {

    private String document_number;
    private String document_type;
    private String name;
    private String first_surname;


    /**
     * Constructor persona, contiene logica de negocio como validaciones del tipo de documento
     * @param document_number   numero de identificacion de la persona
     * @param document_type     tipo de documento de identificacion
     * @param name              nombre de la persona
     * @param first_surname     primer apellido de la persona
     */

    public Person(String document_number, String document_type, String name, String first_surname) {
        validateDocumentType(document_type);
        this.document_number = document_number;
        this.document_type= document_type;
        this.name = name;
        this.first_surname = first_surname;
    }

    /**
     * Valida el tipo de documento si el tipo no es valido genera una excepcion de negocio
     * @param document_type
     */

    public void validateDocumentType(String document_type){
        if(document_type.equals("TI")){
            throw new CreatePersonException("TI is not admitted");
        }
        if(!document_type.equals("CC")  && !document_type.equals("CE")){
            throw new IllegalArgumentException("document_type has an invalid value.");
        }

    }
}
