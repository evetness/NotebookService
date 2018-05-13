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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Maintenance entity that represents the service.
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} annotations helps
 * to generate the required fields.
 * {@link EqualsAndHashCode#callSuper()} calls on the superclass's
 * implementation before calculating for the fields in this class.
 * The {@link ToString#callSuper()} include the result of the superclass's
 * implementation in the output.
 * With the help of the {@link javax.persistence.Entity} annotation we
 * specifies that the class is an entity.
 * The {@link Table#name()} sets the name of the table.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "maintenance")
public class MaintenanceEntity extends BaseEntity<Long> {

    /**
     * Start date of the repair.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "start_date")
    private LocalDate startDate;

    /**
     * End date of the repair.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "end_date")
    private LocalDate endDate;

    /**
     * Faults of the product.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "faults")
    private String faults;

    /**
     * Modification(s) done on the notebook.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "modification")
    private String modification;

    /**
     * Price of the repair.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "price")
    private int price;

    /**
     * The employee who manages the repair(s).
     * With the help of the {@link javax.persistence.ManyToOne} we define a
     * single-valued association to another entity class that
     * has many-to-one multiplicity.
     */
    @ManyToOne
    private EmployeeEntity employee;

    /**
     * Product to be repaired.
     * The {@link javax.persistence.ManyToOne} we define a
     * single-valued association to another entity class that
     * has many-to-one multiplicity.
     */
    @ManyToOne
    private ProductEntity product;
}
