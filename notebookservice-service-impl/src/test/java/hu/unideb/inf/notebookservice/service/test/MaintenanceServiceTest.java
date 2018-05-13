package hu.unideb.inf.notebookservice.service.test;

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
import hu.unideb.inf.notebookservice.persistence.repository.MaintenanceRepository;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.impl.MaintenanceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaintenanceServiceTest {

    @Mock
    private MaintenanceRepository maintenanceRepository;

    @Spy
    @InjectMocks
    private MaintenanceServiceImpl maintenanceService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(maintenanceRepository.save(Mockito.any(MaintenanceEntity.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((MaintenanceEntity) args[0]).getId() == null) {
                        ((MaintenanceEntity) args[0]).setId(91L);
                    }
                    return args[0];
                });
    }

    @Test
    public void addClient() {
        Assert.assertNotNull(maintenanceRepository);
        Assert.assertNotNull(maintenanceService);

        Maintenance newMaintenance = new Maintenance();
        newMaintenance.setEmployee(new Employee());
        newMaintenance.setProduct(new Product());
        newMaintenance.setStartDate(LocalDate.now());
        newMaintenance.setEndDate(LocalDate.now());
        newMaintenance.setFaults("testFault");
        newMaintenance.setModification("testModification");
        newMaintenance.setPrice(10000);

        Maintenance saveMaintenance = maintenanceService.addMaintenance(newMaintenance);

        Assert.assertNotNull(saveMaintenance);
        Assert.assertNull(saveMaintenance.getEmployee());
        Assert.assertNull(saveMaintenance.getProduct());
        Assert.assertNotNull(saveMaintenance.getStartDate());
        Assert.assertNotNull(saveMaintenance.getEndDate());
        Assert.assertNotNull(saveMaintenance.getFaults());
        Assert.assertNotNull(saveMaintenance.getModification());

    }
}
