package hu.unideb.inf.notebookservice.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Domain class of the maintenance for transfer data through layers.
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
public class Maintenance implements Serializable {

    /**
     * Start date of the repair.
     */
    private LocalDate startDate;

    /**
     * End date of the repair.
     */
    private LocalDate endDate;

    /**
     * Faults of the product.
     */
    private String faults;

    /**
     * Modification(s) done on the notebook.
     */
    private String modification;

    /**
     * Price of the repair.
     */
    private int price;

    /**
     * The employee who manages the repair.
     */
    private Employee employee;

    /**
     * The product to be repaired.
     */
    private Product product;
}
