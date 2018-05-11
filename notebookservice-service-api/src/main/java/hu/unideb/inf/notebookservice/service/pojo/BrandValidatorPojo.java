package hu.unideb.inf.notebookservice.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Simple class for brand validator which helps to validate brand domain.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} and
 * {@link lombok.AllArgsConstructor} annotations helps to
 * generate the required fields.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandValidatorPojo {

    /**
     * Boolean for check if the brand registered in the database.
     */
    private boolean registered;

    /**
     * Message for validation.
     */
    private String message;
}
