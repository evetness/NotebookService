package hu.unideb.inf.notebookservice.service.mapper;

import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class helps to convert {@link hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity} entity to
 * {@link hu.unideb.inf.notebookservice.service.domain.Maintenance} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class MaintenanceMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Maintenance} domain object.
     * @param maintenanceEntity is the {@link hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.service.domain.Maintenance} object.
     */
    public static Maintenance MaintenanceEntityToMaintenance(MaintenanceEntity maintenanceEntity) {
        return mapper.map(maintenanceEntity, Maintenance.class);
    }

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.service.domain.Maintenance} to a
     * lower layered {@link hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity} domain object.
     * @param maintenance is the {@link hu.unideb.inf.notebookservice.service.domain.Maintenance} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity} object.
     */
    public static MaintenanceEntity MaintenanceToMaintenanceEntity(Maintenance maintenance) {
        return mapper.map(maintenance, MaintenanceEntity.class);
    }
}
