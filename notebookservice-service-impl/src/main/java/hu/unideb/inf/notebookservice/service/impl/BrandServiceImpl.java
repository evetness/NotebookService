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

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.mapper.BrandMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class manages the brands. This class is annotated by
 * {@link org.springframework.stereotype.Service Service}, it is a more
 * specified {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    /**
     * The BrandRepository derives from {@link BrandRepository}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a brand can be reached
     * by via this data member.
     */
    @Autowired
    private BrandRepository brandRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the brand is stored in the DB with a generated ID.
     * @param brand to be added to the database.
     * @return the stored brand with its ID.
     */
    @Override
    public final Brand addBrand(final Brand brand) {
        log.info(">> add: [brand:{}]", brand);
        return BrandMapper.brandEntityToBrand(
                brandRepository.save(BrandMapper.brandToBrandEntity(brand)));
    }

    /**
     * In this implementation, with the help of
     * {@link BrandRepository#findByName(String)} method, the brand is queried
     * from the database.
     * @param name of the brand.
     * @return the desired brand by its name from the database.
     */
    @Override
    public final Brand findByName(final String name) {
        log.info(">> findByName: [name:{}]", name);
        BrandEntity foundBrand = brandRepository.findByName(name);

        if (foundBrand == null) {
            log.info("<< findByName: [name:{}]", name);
            return null;
        } else {
            log.info("<< findByName: [name:{}]", name);
            return BrandMapper.brandEntityToBrand(foundBrand);
        }
    }

    /**
     * This implementation, with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, all brand is queried from the database to a list.
     * @return a list of all brand.
     */
    @Override
    public final List<Brand> listBrand() {
        log.info(">> listBrand: [brand:{}]");
        List<BrandEntity> brandList = brandRepository.findAll();
        log.info("<< listBrand: [brand:{}]");
        return BrandMapper.brandEntityToBrand(brandList);
    }
}
