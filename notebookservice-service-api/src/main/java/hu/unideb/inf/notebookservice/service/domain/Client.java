package hu.unideb.inf.notebookservice.service.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Domain class of the client for transfer data through layers.
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
public class Client implements Serializable {

    /**
     * Id of the client.
     */
    private Long id;

    /**
     * First name of the client.
     */
    private String firstName;

    /**
     * Last name of the client.
     */
    private String lastName;

    /**
     * Email of the client.
     */
    private String email;

    /**
     * Phone of the client.
     */
    private String phone;

    /**
     * The clients products.
     */
    private List<Product> products;
}
