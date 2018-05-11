package hu.unideb.inf.notebookservice.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Domain class of the product for transfer data through layers.
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
public class Product implements Serializable {

    /**
     * Id of the product.
     */
    private Long id;

    /**
     * Type of the product.
     */
    private String type;

    /**
     * Description of the product fault's.
     */
    private String descrition;

    /**
     * Maintenance of the product.
     */
    private Maintenance maintenance;

    /**
     * Brand of the product.
     */
    private Brand brand;

    /**
     * Product owner.
     */
    private Client client;
}
