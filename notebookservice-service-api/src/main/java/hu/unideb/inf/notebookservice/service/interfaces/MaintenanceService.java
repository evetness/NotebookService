package hu.unideb.inf.notebookservice.service.interfaces;

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

import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;

import java.util.List;

/**
 * Interface that describes the management of the maintenance.
 */
public interface MaintenanceService {

    /**
     * This service adds new maintanace to the database.
     * @param maintenance to be added to the database.
     * @return persisted database maintenance.
     */
    Maintenance addMaintenance(Maintenance maintenance);

    /**
     * This service handles the search for the maintenance in the database.
     * @param id what belongs to the maintenance.
     * @return the maintenance from the database.
     */
    Maintenance findById(Long id);

    /**
     * This service handles the search for a maintenance list in the database.
     * @param employee is whom maintenance we search.
     * @return a list of maintenance from the database.
     */
    List<Maintenance> findByEmployee(Employee employee);

    /**
     * This service edits a maintenance which is already in the database.
     * @param maintenance the maintenance to be edited.
     * @return persisted database maintenance.
     */
    Maintenance editMaintenance(Maintenance maintenance);
}
