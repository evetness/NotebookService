package hu.unideb.inf.notebookservice.service.interfaces;

/*-
 * #%L
 * NotebookService service api
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
