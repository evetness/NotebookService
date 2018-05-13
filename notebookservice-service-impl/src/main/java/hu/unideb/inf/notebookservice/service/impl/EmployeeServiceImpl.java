package hu.unideb.inf.notebookservice.service.impl;

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
    public final Employee addEmployee(final Employee employee) {

        log.info(">> add: [employee:{}]", employee);
        return EmployeeMapper.employeeEntityToEmployee(
                employeeRepository.save(
                        EmployeeMapper.employeeToEmployeeEntity(employee)));
    }

    /**
     * In this implementation, with the help of
     * {@link EmployeeRepository#findByUsername(String)} method,
     * the employee is queried from the database.
     * @param username of the employee.
     * @return the desired employee by its username from the database.
     */
    @Override
    public final Employee findByUsername(final String username) {

        log.info(">> findByUsername: [username:{}]", username);
        EmployeeEntity foundEmployee =
                employeeRepository.findByUsername(username);

        if (foundEmployee == null) {
            log.info("<< findByUsername: [username:{}]", username, null);
            return null;
        } else {
            log.info("<< findByUsername: [username:{}]", username);
            return EmployeeMapper.employeeEntityToEmployee(foundEmployee);
        }
    }
}
