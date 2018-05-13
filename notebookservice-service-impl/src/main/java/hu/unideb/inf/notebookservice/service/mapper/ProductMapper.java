package hu.unideb.inf.notebookservice.service.mapper;

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
import hu.unideb.inf.notebookservice.service.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to convert {@link ProductEntity} entity to
 * {@link Product} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 */
@Component
public class ProductMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link ProductEntity} to a
     * higher layered {@link Product} domain object.
     * @param productEntity is the {@link ProductEntity} to be converted.
     * @return the converted {@link Product} object.
     */
    public static Product productEntityToProduct(
            final ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }

    /**
     * This method converts the {@link Product} to a
     * lower layered {@link ProductEntity} domain object.
     * @param product is the {@link Product} to be converted.
     * @return the converted {@link ProductEntity} object.
     */
    public static ProductEntity productToProductEntity(final Product product) {
        return mapper.map(product, ProductEntity.class);
    }

    /**
     * This method converts a list of {@link ProductEntity} to a
     * higher layered {@link Product} domain object list.
     * @param productEntities is a list of {@link ProductEntity}
     * to be converted.
     * @return a list of the converted {@link Product} object.
     */
    public static List<Product> productEntityToProduct(
            final List<ProductEntity> productEntities) {

        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            products.add(productEntityToProduct(productEntity));
        }

        return products;
    }
}
