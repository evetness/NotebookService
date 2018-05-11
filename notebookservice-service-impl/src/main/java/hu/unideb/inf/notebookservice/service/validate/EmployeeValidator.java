package hu.unideb.inf.notebookservice.service.validate;

import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.interfaces.EmployeeService;
import hu.unideb.inf.notebookservice.service.pojo.EmployeeValidatorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class help to validate the given {@link hu.unideb.inf.notebookservice.service.domain.Employee}.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class EmployeeValidator {

    /**
     * The EmployeService derives from {@link hu.unideb.inf.notebookservice.service.interfaces.EmployeeService}.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a client can be reached by via this data member.
     */
    @Autowired
    EmployeeService employeeService;

    /**
     * This method is check if the register validation is ok.
     * @param employee is the {@link hu.unideb.inf.notebookservice.service.domain.Employee} to be validated.
     * @return a {@link hu.unideb.inf.notebookservice.service.pojo.EmployeeValidatorPojo} which contains the answer.
     */
    public EmployeeValidatorPojo regValidator(Employee employee){

        List<String> message = new ArrayList<>();
        boolean ok = true;

        if (employee.getUsername().isEmpty()) {
            message.add("Username required!");
            ok = false;
        }
        if (employee.getPassword().isEmpty()) {
            message.add("Password required!");
            ok = false;
        }

        if(ok) {
            if (employeeService.findByUsername(employee.getUsername()) == null) {
                message.add("Registration successful!");
                return new EmployeeValidatorPojo(true, message);
            } else {
                message.add("User already exists!");
                return new EmployeeValidatorPojo(false, message);
            }
        } else {
            return new EmployeeValidatorPojo(false, message);
        }
    }

    /**
     * This method is check if the login validation is ok.
     * @param employee is the {@link hu.unideb.inf.notebookservice.service.domain.Employee} to be validated.
     * @return a {@link hu.unideb.inf.notebookservice.service.pojo.EmployeeValidatorPojo} which contains the answer.
     */
    public EmployeeValidatorPojo loginValidator(Employee employee) {

        Employee foundEmployee = employeeService.findByUsername(employee.getUsername());

        List<String> message = new ArrayList<>();

        if(foundEmployee == null) {
            message.add("Wrong username!");
            return new EmployeeValidatorPojo(false, message);
        } else if(foundEmployee.getPassword().equals(employee.getPassword())) {
            message.add("Success!");
            return new EmployeeValidatorPojo(true,message);
        } else {
            message.add("Wrong password!");
            return new EmployeeValidatorPojo(false, message);
        }
    }

}
