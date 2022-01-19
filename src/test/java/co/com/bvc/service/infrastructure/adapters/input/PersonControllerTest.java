package co.com.bvc.service.infrastructure.adapters.input;

import co.com.bvc.service.application.ports.input.IPersonPort;
import co.com.bvc.service.infrastructure.dto.PersonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


class PersonControllerTest {

    public MockMvc mockMvc;
    @Mock
    private IPersonPort iPerson;

    @InjectMocks
    PersonController personController;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void postPerson() {

      when(iPerson.createPerson(anyString(),anyString(),anyString(),anyString())).thenReturn(true);


      /*  PersonDTO personDTO= new PersonDTO();

        Assertions.assertThrows(MethodArgumentNotValidException.class, () -> {
            personController.postPerson(personDTO);
        });

        personDTO.setDocument_number("12345");
        personDTO.setDocument_type("CC");
        personDTO.setName("Paola");
        personDTO.setFirst_surname("Avella");
        ResponseEntity<String> responseEntity = new ResponseEntity<>("La persona se creo con exito", HttpStatus.OK);
        Assertions.assertEquals(responseEntity, personController.postPerson(personDTO));
   */


     // personDTO.setDocument_number("12345");

     // Assertions.assertEquals("La persona se creo con exito",personController.postPerson(personDTO));

    }
}