package hu.unideb.inf.notebookservice.persistence.repository;

import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of the maintenance, that communicates with the database.
 * The {@link org.springframework.stereotype.Repository} indicates
 * that the annotated class is a repository.
 */
@Repository
public interface MaintenanceRepository
        extends JpaRepository<MaintenanceEntity, Long> {

    /**
     * Searches through the Maintenance table for
     * the maintenance by its product.
     * @param product is the maintenance product.
     * @return the maintenance by its product.
     */
    MaintenanceEntity findByProduct(ProductEntity product);

}
