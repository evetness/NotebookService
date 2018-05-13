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

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to convert {@link BrandEntity} entity to {@link Brand}
 * domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that an
 * annotated class is a "component".
 */
@Component
public class BrandMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link BrandEntity} to a
     * higher layered {@link Brand} domain object.
     * @param brandEntity is the {@link BrandEntity} to be converted.
     * @return the converted {@link Brand} object.
     */
    public static Brand brandEntityToBrand(final BrandEntity brandEntity) {
        return mapper.map(brandEntity, Brand.class);
    }

    /**
     * This method converts the {@link Brand} to a
     * lower layered {@link BrandEntity} domain object.
     * @param brand is the {@link Brand} to be converted.
     * @return the converted {@link BrandEntity} object.
     */
    public static BrandEntity brandToBrandEntity(final Brand brand) {
        return mapper.map(brand, BrandEntity.class);
    }

    /**
     * This method converts a list of {@link BrandEntity} to a
     * higher layered {@link Brand} domain object list.
     * @param brandEntities is a list of {@link BrandEntity} to be converted.
     * @return a list of the converted {@link Brand} object.
     */
    public static List<Brand> brandEntityToBrand(
            final List<BrandEntity> brandEntities) {

        List<Brand> brands = new ArrayList<>();
        for (BrandEntity brandEntity : brandEntities) {
            brands.add(brandEntityToBrand(brandEntity));
        }

        return brands;
    }

    /**
     * This method converts a list of {@link Brand} to a
     * higher layered {@link BrandEntity} domain object list.
     * @param brands is a list of {@link Brand} to be converted.
     * @return a list of the converted {@link BrandEntity} object.
     */
    public static List<BrandEntity> brandToBrandEntity(
            final List<Brand> brands) {

        List<BrandEntity> brandEntities = new ArrayList<>();
        for (Brand brand : brands) {
            brandEntities.add(brandToBrandEntity(brand));
        }

        return brandEntities;
    }

}
