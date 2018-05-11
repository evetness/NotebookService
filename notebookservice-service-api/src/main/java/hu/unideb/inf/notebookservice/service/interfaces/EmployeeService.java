package hu.unideb.inf.notebookservice.service.interfaces;

import hu.unideb.inf.notebookservice.service.domain.Employee;

/**
 * Interface that describes the management of the employees.
 */
public interface EmployeeService {

    /**
     * This service adds new employee to the database.
     * @param employee to be added to the database.
     * @return persisted database employee.
     */
    Employee addEmployee(Employee employee);

    /**
     * This service handles the search for the employee in the database
     * by its username.
     * @param username of the employee.
     * @return the employee from the database.
     */
    Employee findByUsername(String username);
}
