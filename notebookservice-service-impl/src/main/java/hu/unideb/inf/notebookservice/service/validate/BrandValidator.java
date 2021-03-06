package hu.unideb.inf.notebookservice.service.validate;

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

import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.pojo.BrandValidatorPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class help to validate the given {@link Brand}.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Component
public class BrandValidator {

    /**
     * The BrandService derives from {@link BrandService}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a brand can be reached
     * by via this data member.
     */
    @Autowired
    private BrandService brandService;

    /**
     * This method is check if validation is ok.
     * @param brand is the {@link Brand} to be validated.
     * @return a {@link BrandValidatorPojo} which contains the answer.
     */
    public final BrandValidatorPojo regValidator(final Brand brand) {
        log.info(">> validate: [brand:{}]", brand);
        if (brand.getName().isEmpty()) {
            log.info("<< not valid: [brand:{}]", brand);
            return new BrandValidatorPojo(false, "Incorrect Brand name!");
        } else if (brandService.findByName(brand.getName()) == null) {
            log.info("<< valid: [brand:{}]", brand);
            return new BrandValidatorPojo(true, "Done!");
        } else {
            log.info("not valid: [brand:{}]", brand);
            return new BrandValidatorPojo(false, "Brand already exists!");
        }
    }
}
