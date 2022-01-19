package co.com.bvc.service.application.service;
import co.com.bvc.service.application.ports.input.IPersonPort;
import co.com.bvc.service.domain.model.Person;
import co.com.bvc.service.application.ports.output.IPersonPersistencePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PersonImpl implementacion del caso de uso
 * @version 09/11/2021
 * @author Paola Avella
 *
 */
@Service
public class PersonPortImpl implements IPersonPort {

    private IPersonPersistencePort personPersistence;

    /**
     * constructor en el cual se hace inyeccion del puerto de salida para la persistencia
     * @param personPersistence
     */
    @Autowired
    public PersonPortImpl(IPersonPersistencePort personPersistence) {this.personPersistence = personPersistence;}
    /**
     * Metodo con logica de negocio, el cual instancia la entidad Persona
     * @param document_number numero de documento de la persona
     * @param document_type tipo de docuemnto de la persona
     * @param name nombre de la persona
     * @param first_surname primer apellido de la persona
     * @return retorna true cuando se puede crear a la persona
     */
    @Override
    public boolean createPerson(String document_number,String document_type,String name,String first_surname){
        Person person =new Person(document_number,document_type,name,first_surname);
        return personPersistence.createPerson(person);
    }


}
