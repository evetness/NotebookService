package hu.unideb.inf.notebookservice.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Simple class for client validator which helps
 * to validate the client domain.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} and
 * {@link lombok.AllArgsConstructor} annotations helps to
 * generate the required fields.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientValidatorPojo {

    /**
     * Boolean for check if the client is registered in the database.
     */
    private boolean registered;

    /**
     * List of massage for the validator.
     */
    private List<String> message;

    @Override
    public String toString() {
        return String.join(" ", message);
    }
}
