package hu.unideb.inf.notebookservice.service.validate;

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

import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.interfaces.EmployeeService;
import hu.unideb.inf.notebookservice.service.pojo.EmployeeValidatorPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class help to validate the given {@link Employee}.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Component
public class EmployeeValidator {

    /**
     * The EmployeService derives from {@link EmployeeService}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a client can be reached
     * by via this data member.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * This method is check if the register validation is ok.
     * @param employee is the {@link Employee} to be validated.
     * @return a {@link EmployeeValidatorPojo} which contains the answer.
     */
    public final EmployeeValidatorPojo regValidator(final Employee employee) {

        log.info(">> validate: [employee:{}]", employee);
        List<String> message = new ArrayList<>();
        boolean ok = true;

        if (employee.getUsername().isEmpty()) {
            log.info("<< not valid: [username:{}]", employee.getUsername());
            message.add("Username required!");
            ok = false;
        }
        if (employee.getPassword().isEmpty()) {
            log.info("<< not valid: [password:{}]", employee.getPassword());
            message.add("Password required!");
            ok = false;
        }

        if (ok) {
            if (employeeService
                    .findByUsername(employee.getUsername()) == null) {

                log.info("<< valid: [employee:{}]", employee);
                message.add("Registration successful!");
                return new EmployeeValidatorPojo(true, message);
            } else {

                log.info("<< not valid: [employee:{}]", employee);
                message.add("User already exists!");
                return new EmployeeValidatorPojo(false, message);
            }
        } else {

            log.info("<< not valid: [employee:{}]", employee);
            return new EmployeeValidatorPojo(false, message);
        }
    }

    /**
     * This method is check if the login validation is ok.
     * @param employee is the {@link Employee} to be validated.
     * @return a {@link EmployeeValidatorPojo} which contains the answer.
     */
    public final EmployeeValidatorPojo loginValidator(
            final Employee employee) {

        log.info(">> validate: [employee:{}]", employee);
        Employee foundEmployee = employeeService
                .findByUsername(employee.getUsername());

        List<String> message = new ArrayList<>();

        if (foundEmployee == null) {

            log.info("<< not valid: [employee:{}]", employee);
            message.add("Wrong username!");
            return new EmployeeValidatorPojo(false, message);
        } else if (foundEmployee.getPassword()
                .equals(employee.getPassword())) {

            log.info("<< valid: [employee:{}]", employee);
            message.add("Success!");
            return new EmployeeValidatorPojo(true, message);
        } else {

            log.info("<< valid: [employee:{}]", employee.getPassword());
            message.add("Wrong password!");
            return new EmployeeValidatorPojo(false, message);
        }
    }

}
