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
import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.persistence.repository.MaintenanceRepository;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.interfaces.MaintenanceService;
import hu.unideb.inf.notebookservice.service.mapper.EmployeeMapper;
import hu.unideb.inf.notebookservice.service.mapper.MaintenanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class manages the maintenance. This class is annotated by
 * {@link org.springframework.stereotype.Service Service}, it is a more
 * specified {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    /**
     * The MaintenanceRepository derives from {@link MaintenanceRepository}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a maintenance can be reached
     * by via this data member.
     */
    @Autowired
    private MaintenanceRepository maintenanceRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the maintenance is stored in the DB with a generated ID.
     * @param maintenance to be added to the database.
     * @return the stored maintenance with its ID.
     */
    @Override
    public final Maintenance addMaintenance(final Maintenance maintenance) {
        log.info(">> add: [maintenance:{}]", maintenance);
        return MaintenanceMapper
                .maintenanceEntityToMaintenance(maintenanceRepository.save(
                        MaintenanceMapper
                                .maintenanceToMaintenanceEntity(maintenance)));
    }

    /**
     * In this implementation, with the help of
     * {@link MaintenanceRepository#findById(Object)} method,
     * the maintenance is queried from the database.
     * @param id that belongs to the maintenance.
     * @return the desired maintenance.
     */
    @Override
    public final Maintenance findById(final Long id) {

        log.info(">> findById: [product:{}]", id);
        Optional<MaintenanceEntity> foundMaintenance =
                maintenanceRepository.findById(id);

        log.info("<< findById: [maintenance:{}]",
                foundMaintenance.isPresent());
        return MaintenanceMapper
                .maintenanceEntityToMaintenance(foundMaintenance.get());

    }

    @Override
    public final List<Maintenance> findByEmployee(final Employee employee) {

        EmployeeEntity foundEmployee =
                EmployeeMapper.employeeToEmployeeEntity(employee);

        log.info(">> listMaintenance: [maintenance:{}]");
        List<MaintenanceEntity> maintenanceList =
                maintenanceRepository.findByEmployee(foundEmployee);
        log.info("<< listMaintenance: [maintenance:{}]");
        return MaintenanceMapper
                .maintenanceEntityToMaintenance(maintenanceList);
    }

    @Override
    public final Maintenance editMaintenance(final Maintenance maintenance) {

        log.info(">> edit: [maintenance:{}]", maintenance);
        return MaintenanceMapper
                .maintenanceEntityToMaintenance(maintenanceRepository.save(
                        MaintenanceMapper
                                .maintenanceToMaintenanceEntity(maintenance)));
    }
}
