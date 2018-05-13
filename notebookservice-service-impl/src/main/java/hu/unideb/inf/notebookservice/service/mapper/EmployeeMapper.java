package hu.unideb.inf.notebookservice.service.mapper;

/*-
 * #%L
 * NotebookService Implementation
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2018 University of Debrecen IT Faculty
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class helps to convert {@link EmployeeEntity} entity to
 * {@link Employee} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 */
@Component
public class EmployeeMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link EmployeeEntity} to a
     * higher layered {@link Employee} domain object.
     * @param employeeEntity is the {@link EmployeeEntity} to be converted.
     * @return the converted {@link Employee} object.
     */
    public static Employee employeeEntityToEmployee(
            final EmployeeEntity employeeEntity) {
        return mapper.map(employeeEntity, Employee.class);
    }

    /**
     * This method converts the {@link Employee} to a
     * lower layered {@link EmployeeEntity} domain object.
     * @param employee is the {@link Employee} to be converted.
     * @return the converted {@link EmployeeEntity} object.
     */
    public static EmployeeEntity employeeToEmployeeEntity(
            final Employee employee) {
        return mapper.map(employee, EmployeeEntity.class);
    }

}
