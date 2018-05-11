package hu.unideb.inf.notebookservice.service.interfaces;

import hu.unideb.inf.notebookservice.service.domain.Brand;

import java.util.List;

/**
 * Interface that describes the management of the brands.
 */
public interface BrandService {

    /**
     * This service adds new brand to the database.
     * @param brand to be added to the database.
     * @return persisted database member.
     */
    Brand addBrand(Brand brand);

    /**
     * This service handles the search for the brand in the database.
     * @param name of the brand.
     * @return the brand from the database.
     */
    Brand findByName(String name);

    /**
     * This service creates a list of the brands.
     * @return a brand list.
     */
    List<Brand> listBrand();
}
