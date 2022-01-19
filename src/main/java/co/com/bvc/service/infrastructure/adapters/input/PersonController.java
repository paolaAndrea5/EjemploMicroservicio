package co.com.bvc.service.infrastructure.adapters.input;
import co.com.bvc.service.application.ports.input.IPersonPort;
import co.com.bvc.service.application.ports.output.IConectorPort;
import co.com.bvc.service.infrastructure.dto.PersonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Controlador Rest que recibe peticiones desde afuera de la aplicacion
 * Adaptador de entrada
 * @version 09/11/2021
 * @author Paola Avella
 */
@RestController
@RequestMapping(path = "person")
@Validated
public class PersonController {

    private IPersonPort iPerson;

    private IConectorPort iConectorPort;

    /**
     * constructor en el cual se hace inyeccion del puerto de entrada del caso de uso
     * @param iPerson
     */

    public PersonController(IPersonPort iPerson, IConectorPort iConectorPort) {
        this.iPerson = iPerson;
        this.iConectorPort=iConectorPort;
    }

    /**
     * Recibe las peticion post
     * Accede a la funcionalidad del caso de uso crear persona mediante el puerto de entradaRecibe las peticion post
     * Accede a la funcionalidad del caso de uso crear persona mediante el puerto de entrada
     * @param personDTO
     * @return
     */
    @PostMapping("/create")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    public ResponseEntity<String> postPerson(@Valid @RequestBody PersonDTO personDTO) throws MethodArgumentNotValidException{
       String respuesta ="";
       boolean res=iPerson.createPerson(personDTO.getDocument_number(),personDTO.getDocument_type(),personDTO.getName(),personDTO.getFirst_surname());

        if(res){
           respuesta="La persona se creo con exito";
       }
       return new ResponseEntity<>(respuesta, HttpStatus.OK);


    }
    @GetMapping("/consult")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public ResponseEntity<String> getDocType() {

        List<String> docTypes= iConectorPort.getlistDocType();
       // docTypes.stream().filter()
        if(docTypes.contains("NI")){
            return new ResponseEntity<>("CC", HttpStatus.OK);
        }

        return new ResponseEntity<>("hola", HttpStatus.OK);


    }


}
