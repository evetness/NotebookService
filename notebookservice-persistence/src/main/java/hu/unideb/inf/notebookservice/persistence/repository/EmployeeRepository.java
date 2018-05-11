package hu.unideb.inf.notebookservice.persistence.repository;

import hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository of the employee, that communicates with the database.
 * The {@link org.springframework.stereotype.Repository} indicates
 * that the annotated class is a repository.
 */
@Repository
public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {

    /**
     * Searches through the Employee table for the employee by its username.
     * @param username is the employee name.
     * @return the employee by the username.
     */
    EmployeeEntity findByUsername(String username);
}
