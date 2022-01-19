package co.com.bvc.service.infrastructure.jpa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.*;

/**
 * Entidad para la persistencia de una persona
 * @version 09/11/2021
 * @author Paola Avella
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personjpa")
public class PersonJPA {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String document_number;
    private String document_type;
    private String name;
    private String first_surname;

}
