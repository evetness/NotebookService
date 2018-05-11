package hu.unideb.inf.notebookservice.service.interfaces;

import hu.unideb.inf.notebookservice.service.domain.Product;

import java.util.List;

/**
 * Interface that describes the management of the product.
 */
public interface ProductService {

    /**
     * This service adds new product to the database.
     * @param product to be added to the database.
     * @return persisted database product.
     */
    Product addProduct(Product product);

    /**
     * This service handles the search for the product
     * by its id in the database.
     * @param id of the product.
     * @return the product from the database.
     */
    Product findProduct(Long id);

    /**
     * This service creates a list of the products.
     * @return a product list.
     */
    List<Product> listProduct();

}
