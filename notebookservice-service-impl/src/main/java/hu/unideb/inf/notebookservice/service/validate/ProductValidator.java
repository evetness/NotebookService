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

import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.ProductService;
import hu.unideb.inf.notebookservice.service.pojo.ProductValidatorPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class help to validate the given {@link Product}.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Component
public class ProductValidator {

    /**
     * The ProductService derives from {@link ProductService}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a client can be reached
     * by via this data member.
     */
    @Autowired
    private ProductService productService;

    /**
     * This method is check if validation for registering the product is ok.
     * @param product is the {@link Product} to be validated.
     * @return a {@link ProductValidatorPojo} which contains the answer.
     */
    public final ProductValidatorPojo regValidator(final Product product) {
        log.info(">> validate: [product:{}]", product);
        List<String> message = new ArrayList<>();
        boolean ok = true;

        if (product.getType().isEmpty()) {
            log.info("<< not valid: [type:{}]", product.getType());
            message.add("Type is required!");
            ok = false;
        }
        if (product.getDescrition().isEmpty()) {

            log.info("<< not valid: [description:{}]", product.getDescrition());
            message.add("Description is required!");
            ok = false;
        }

        if (ok) {

            log.info(">> valid: [product:{}]", product);
            message.add("Success!");
            return new ProductValidatorPojo(true, message);
        } else {

            log.info("<< not valid: [product:{}]", product);
            return new ProductValidatorPojo(false, message);
        }

    }
}
