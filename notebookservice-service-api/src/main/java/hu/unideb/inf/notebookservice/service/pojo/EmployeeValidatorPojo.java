package hu.unideb.inf.notebookservice.service.pojo;

/*-
 * #%L
 * NotebookService service api
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
    public final String toString() {
        return String.join(" ", message);
    }

}
