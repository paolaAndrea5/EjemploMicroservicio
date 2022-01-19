package co.com.bvc.service.application.ports.output;

import co.com.bvc.service.domain.model.Person;
/**
 * Puerto de salida para acceder a la persistencia ubicada en la capa de infraestructura
 * @version 09/11/2021
 * @author Paola Avella
 *
 */
public interface IPersonPersistencePort {
    /**
     *Representa una funcion del puerto de salida para acceder a la persistencia de una persona en base de datos
     * @param person data de la persona
     * @return retorna true cuando se puede persistir en bd
     */
    boolean createPerson(Person person);
}
