package hu.unideb.inf.notebookservice.service.domain;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Domain class of the product for transfer data through layers.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} and
 * {@link lombok.AllArgsConstructor} annotations helps to
 * generate the required fields.
 * The {@link lombok.Builder} annotation creates a so-called 'builder'
 * aspect to the class.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    /**
     * Id of the product.
     */
    private Long id;

    /**
     * Type of the product.
     */
    private String type;

    /**
     * Description of the product fault's.
     */
    private String descrition;

    /**
     * Maintenance of the product.
     */
    private Maintenance maintenance;

    /**
     * Brand of the product.
     */
    private Brand brand;

    /**
     * Product owner.
     */
    private Client client;
}
