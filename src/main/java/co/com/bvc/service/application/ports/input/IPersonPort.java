package co.com.bvc.service.application.ports.input;

/**
 * Puerto de entrada para acceder a los casos de uso
 * @version 09/11/2021
 * @author Paola Avella
 *
 */
public interface IPersonPort {
  /**
   *  Representa una funcion del puerto de entrada para acceder a la implementacion del caso de uso
   *  de la creacion de la persona
   * @param document_number   numero de identificacion de la persona
   * @param document_type     tipo de documento de identificacion
   * @param name              nombre de la persona
   * @param first_surname     primer apellido de la persona
   * @return retorna true cuando se puede crear a la persona
   */
  boolean createPerson(String document_number,String document_type,String name,String first_surname);
}
