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

import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to convert {@link MaintenanceEntity} entity to
 * {@link Maintenance} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 */
@Component
public class MaintenanceMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link MaintenanceEntity} to a
     * higher layered {@link Maintenance} domain object.
     * @param maintenanceEntity is the {@link MaintenanceEntity}
     * to be converted.
     * @return the converted {@link Maintenance} object.
     */
    public static Maintenance maintenanceEntityToMaintenance(
            final MaintenanceEntity maintenanceEntity) {
        return mapper.map(maintenanceEntity, Maintenance.class);
    }

    /**
     * This method converts the {@link Maintenance} to a
     * lower layered {@link MaintenanceEntity} domain object.
     * @param maintenance is the {@link Maintenance} to be converted.
     * @return the converted {@link MaintenanceEntity} object.
     */
    public static MaintenanceEntity maintenanceToMaintenanceEntity(
            final Maintenance maintenance) {
        return mapper.map(maintenance, MaintenanceEntity.class);
    }

    /**
     * This method converts a list of {@link MaintenanceEntity} to a
     * higher layered {@link Maintenance} domain object list.
     * @param maintenanceEntities is a list of {@link MaintenanceEntity}
     *                           to be converted.
     * @return a list of the converted {@link Maintenance} object.
     */
    public static List<Maintenance> maintenanceEntityToMaintenance(
            final List<MaintenanceEntity> maintenanceEntities) {

        List<Maintenance> maintenances = new ArrayList<>();
        for (MaintenanceEntity maintenanceEntity : maintenanceEntities) {
            maintenances.add(
                    maintenanceEntityToMaintenance(maintenanceEntity));
        }

        return maintenances;
    }
}
