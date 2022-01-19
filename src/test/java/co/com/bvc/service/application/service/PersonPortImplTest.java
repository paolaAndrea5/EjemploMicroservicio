package co.com.bvc.service.application.service;

import co.com.bvc.service.application.ports.output.IPersonPersistencePort;
import co.com.bvc.service.domain.exceptions.CreatePersonException;
import co.com.bvc.service.domain.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonPortImplTest {

    // simula dependencias
    @Mock
    private IPersonPersistencePort personPersistence;

    // inyecta los mocks en la clase que vamos a probar
    @InjectMocks
    PersonPortImpl personImp;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPerson() {
        when(personPersistence.createPerson(any(Person.class))).thenReturn(true);



        Assertions.assertEquals(true, personImp.createPerson("123","CE","Paola","Avella"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personImp.createPerson("123","Ccc","Paola","Avella");
        });

        Assertions.assertThrows(CreatePersonException.class, () -> {
            personImp.createPerson("123","TI","Paola","Avella");
        });
    }

}