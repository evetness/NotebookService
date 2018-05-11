package hu.unideb.inf.notebookservice.service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Simple class for employee validator which helps
 * to validate the employee domain.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} and
 * {@link lombok.AllArgsConstructor} annotations helps to
 * generate the required fields.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeValidatorPojo {

    /**
     * Boolean for check if the employee is registered.
     */
    private boolean registered;

    /**
     * List of message for the validator.
     */
    private List<String> message;

    @Override
    public String toString() {
        return String.join(" ", message);
    }
}
