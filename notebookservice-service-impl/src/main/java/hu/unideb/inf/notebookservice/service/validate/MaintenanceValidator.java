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

import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.interfaces.MaintenanceService;
import hu.unideb.inf.notebookservice.service.pojo.MaintenanceValidatorPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class help to validate the given {@link Maintenance}.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Component
public class MaintenanceValidator {

    /**
     * The BrandService derives from {@link MaintenanceService}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a brand can be reached
     * by via this data member.
     */
    @Autowired
    private MaintenanceService maintenanceService;

//    /**
//     * This method is check if validation is ok.
//     * @param maintenance is the {@link Maintenance} to be validated.
//     * @return a {@link MaintenanceValidatorPojo} which contains the answer.
//     */
//    public final MaintenanceValidatorPojo regValidator(final Maintenance maintenance) {
//        log.info(">> validate: [maintenance:{}]", maintenance);
//        if (maintenance.getPrice()) {
//            log.info("<< not valid: [brand:{}]", brand);
//            return new MaintenanceValidatorPojo(false, "Incorrect Brand name!");
//        } else {
//            log.info("not valid: [brand:{}]", brand);
//            return new MaintenanceValidatorPojo(false, "Brand already exists!");
//        }
//    }
}
