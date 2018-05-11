package hu.unideb.inf.notebookservice.service.interfaces;

import hu.unideb.inf.notebookservice.service.domain.Maintenance;

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

}
