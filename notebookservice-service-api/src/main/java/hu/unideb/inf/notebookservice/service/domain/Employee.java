package hu.unideb.inf.notebookservice.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Domain class of the employee for transfer data through layers.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} and
 * {@link lombok.AllArgsConstructor} annotations helps to
 * generate the required fields.
 * The {@link lombok.Builder} annotation creates a so-called 'builder'
 * aspect to the class.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    /**
     * Id of the employee.
     */
    private Long id;

    /**
     * Username of the employee.
     */
    private String username;

    /**
     * Password of the employee.
     */
    private String password;

    /**
     * List of maintenance for the emyploee.
     */
    private List<Maintenance> maintenances;
}
