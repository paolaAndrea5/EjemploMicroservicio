package co.com.bvc.service.infrastructure.jpa;

import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que proporciona un crud en el repositoria para la entidad persona
 * @version 09/11/2021
 * @author Paola Avella
 */
public interface IPersonRepository extends CrudRepository<PersonJPA, Long>  {
}
