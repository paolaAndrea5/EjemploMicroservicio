package co.com.bvc.service.infrastructure.adapters.output;

import co.com.bvc.service.domain.model.Person;
import co.com.bvc.service.infrastructure.exceptions.PersistenceException;
import co.com.bvc.service.infrastructure.jpa.IPersonRepository;
import co.com.bvc.service.infrastructure.jpa.PersonJPA;
import co.com.bvc.service.application.ports.output.IPersonPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * implementacion del adaptador de salida para la persistencia
 * @version 09/11/2021
 * @author Paola Avella
 */
@Component
public class PersonPersistenceAdapter implements IPersonPersistencePort {
    /**
     * Inyeccion de dependencia de la intefaz para la persistencia
     */
     @Autowired
     private IPersonRepository personRepository;

    /**
     * utiliza la dependencia para guardar a la persona en bd
     * cuando no se puede guardar genera una excepcion de infraestructura
     * @param person data de la persona
     * @return retorna true cuando se puede crear la persona
     */
    public boolean createPerson(Person person){

        try{
            PersonJPA personJPA = new PersonJPA();
            personJPA.setDocument_number(person.getDocument_number());
            personJPA.setDocument_type(person.getDocument_type());
            personJPA.setName(person.getName());
            personJPA.setFirst_surname(person.getFirst_surname());

            personRepository.save(personJPA);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }

        return true;
    }


}
