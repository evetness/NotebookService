package hu.unideb.inf.notebookservice.service.impl;

import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import hu.unideb.inf.notebookservice.persistence.repository.MaintenanceRepository;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.MaintenanceService;
import hu.unideb.inf.notebookservice.service.mapper.MaintenanceMapper;
import hu.unideb.inf.notebookservice.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class manages the maintenance.
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specified {@link org.springframework.stereotype.Component Component}.
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
    MaintenanceRepository maintenanceRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the maintenance is stored in the DB with a generated ID.
     * @param maintenance to be added to the database.
     * @return the stored maintenance with its ID.
     */
    @Override
    public Maintenance addMaintenance(Maintenance maintenance) {

        Maintenance newMaintenance = MaintenanceMapper
                .MaintenanceEntityToMaintenance(maintenanceRepository.save(
                        MaintenanceMapper
                                .MaintenanceToMaintenanceEntity(maintenance)));

        return newMaintenance;
    }
}
