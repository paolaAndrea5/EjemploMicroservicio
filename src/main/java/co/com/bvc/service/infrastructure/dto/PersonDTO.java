package co.com.bvc.service.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Objeto de trasferencia
 * @version 09/11/2021
 * @author Paola Avella
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {

    @NotNull
    @NotBlank
    @Valid
    private String document_number;

    @NotNull
    @NotBlank
    @Valid
    private String document_type;

    @NotNull
    @NotBlank
    @Valid
    private String name;

    @NotNull
    @NotBlank
    @Valid
    private String first_surname;
}