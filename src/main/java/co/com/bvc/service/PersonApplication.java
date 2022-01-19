package co.com.bvc.service;

import co.com.bvc.service.application.ports.input.IPersonPort;
import co.com.bvc.service.application.ports.output.IConectorPort;
import co.com.bvc.service.application.ports.output.IPersonPersistencePort;
import co.com.bvc.service.application.service.PersonPortImpl;
import co.com.bvc.service.infrastructure.adapters.input.PersonController;
import co.com.bvc.service.infrastructure.adapters.output.ConectorAdapter;
import co.com.bvc.service.infrastructure.adapters.output.PersonPersistenceAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
		IPersonPersistencePort personPersistencePort = new PersonPersistenceAdapter();
		IPersonPort personUseCase = new PersonPortImpl(personPersistencePort);
		IConectorPort iConectorPort= new ConectorAdapter();
		PersonController personController = new PersonController(personUseCase, iConectorPort);
	}

}
