package hu.unideb.inf.notebookservice.persistence.repository;

/*-
 * #%L
 * Notebook Service persistence
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
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository of the brand, that communicates with the database.
 * The {@link org.springframework.stereotype.Repository} indicates
 * that the annotated class is a repository.
 */
@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

    /**
     * Searches through the Brand table for the brand by its name.
     * @param name of the brand.
     * @return It returns the Brand that is found by name.
     */
    BrandEntity findByName(String name);
}
