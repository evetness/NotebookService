package hu.unideb.inf.notebookservice.service.impl;

import hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.persistence.repository.EmployeeRepository;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.interfaces.EmployeeService;
import hu.unideb.inf.notebookservice.service.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class manages the employee.
 * This class is annotated by
 * {@link org.springframework.stereotype.Service Service},
 * it is a more specified
 * {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * The EmployeeRepository derives from {@link EmployeeRepository}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a employee can be reached
     * by via this data member.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the employee is stored in the DB with a generated ID.
     * @param employee to be added to the database.
     * @return the stored employee with its ID.
     */
    @Override
    public Employee addEmployee(Employee employee) {

        return EmployeeMapper.EmployeeEntityToEmployee(
                employeeRepository.save(
                        EmployeeMapper.EmployeeToEmployeeEntity(employee)));
    }

    /**
     * In this implementation, with the help of
     * {@link BrandRepository#findByName(String)} method,
     * the employee is queried from the database.
     * @param username of the employee.
     * @return the desired employee by its username from the database.
     */
    @Override
    public Employee findByUsername(String username) {

        EmployeeEntity foundEmployee = employeeRepository.findByUsername(username);

        if(foundEmployee == null)
            return null;
        else
            return EmployeeMapper.EmployeeEntityToEmployee(foundEmployee);
    }
}
