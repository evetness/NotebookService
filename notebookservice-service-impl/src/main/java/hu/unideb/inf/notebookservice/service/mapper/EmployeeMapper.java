package hu.unideb.inf.notebookservice.service.mapper;

import hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to convert {@link hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity} entity to
 * {@link hu.unideb.inf.notebookservice.service.domain.Employee} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class EmployeeMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Employee} domain object.
     * @param employeeEntity is the {@link hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.service.domain.Employee} object.
     */
    public static Employee EmployeeEntityToEmployee(EmployeeEntity employeeEntity) {
        return mapper.map(employeeEntity, Employee.class);
    }

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.service.domain.Employee} to a
     * lower layered {@link hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity} domain object.
     * @param employee is the {@link hu.unideb.inf.notebookservice.service.domain.Employee} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity} object.
     */
    public static EmployeeEntity EmployeeToEmployeeEntity(Employee employee) {
        return mapper.map(employee, EmployeeEntity.class);
    }

}
