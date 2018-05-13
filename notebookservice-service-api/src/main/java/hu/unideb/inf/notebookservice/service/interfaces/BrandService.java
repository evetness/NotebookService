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
