package hu.unideb.inf.notebookservice.persistence.entity;

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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Base entity which provides the primary key.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} and
 * {@link lombok.AllArgsConstructor} annotations helps to generate the required
 * fields.
 * The {@link javax.persistence.MappedSuperclass} mapping information that is
 * applied to the entities that inherit from it.
 * @param <T> the primary key type.
 */
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
class BaseEntity<T extends Serializable> implements Serializable {

    /**
     * ID as primary  key.
     * {@link javax.persistence.Id} specifies the primary key for an entity.
     * The {@link javax.persistence.GeneratedValue} helps to generate the id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

}
