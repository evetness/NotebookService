package hu.unideb.inf.notebookservice.persistence.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

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
     * The {@link javax.persistence.OneToOne} defines a single-valued
     * association to another entity that has one-to-one multiplicity.
     */
    @OneToOne
    private ProductEntity product;
}
