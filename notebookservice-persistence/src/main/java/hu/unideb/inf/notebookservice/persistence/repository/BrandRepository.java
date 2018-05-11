package hu.unideb.inf.notebookservice.persistence.repository;

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository of the brand, that communicates with the database.
 * The {@link org.springframework.stereotype.Repository} indicates
 * that the annotated class is a repository.
 */
@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    /**
     * Searches through the Brand table for the brand by its name.
     * @param name of the brand.
     * @return It returns the Brand that is found by name.
     */
    BrandEntity findByName(String name);
}
