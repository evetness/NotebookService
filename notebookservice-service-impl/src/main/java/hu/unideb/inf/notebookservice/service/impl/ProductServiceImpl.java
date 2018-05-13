package hu.unideb.inf.notebookservice.service.impl;

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

import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import hu.unideb.inf.notebookservice.persistence.repository.ProductRepository;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.ProductService;
import hu.unideb.inf.notebookservice.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class manages the product. This class is annotated by
 * {@link org.springframework.stereotype.Service Service}, it is a more
 * specified {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * The ProductRepository derives from {@link ProductRepository}. This data
     * member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a product can be reached
     * by via this data member.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the product is stored in the DB with a generated ID.
     * @param product to be added to the database.
     * @return the stored product with its ID.
     */
    @Override
    public final Product addProduct(final Product product) {

        log.info(">> add: [product:{}]", product);
        return ProductMapper.productEntityToProduct(
                productRepository.save(
                        ProductMapper.productToProductEntity(product)));
    }

    @Override
    public final Product findProduct(final Long id) {

        log.info(">> findProduct: [productID:{}]", id);
        Optional<ProductEntity> foundProduct = productRepository.findById(id);

        log.info("<< findProduct: [productID:{}]", id);
        return ProductMapper.productEntityToProduct(foundProduct.get());
    }

    /**
     * In this implementation, with the help of
     * {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}
     * method, all product is queried from the database.
     * @return a list of all product from the database.
     */
    @Override
    public final List<Product> listProduct() {

        log.info(">> listProduct: [product:{}]");
        List<ProductEntity> productList = productRepository.findAll();

        log.info("<< listProduct: [product:{}]");
        return ProductMapper.productEntityToProduct(productList);
    }
}
