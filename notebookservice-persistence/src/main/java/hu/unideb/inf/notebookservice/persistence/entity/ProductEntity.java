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

/**
 * Product entity that represents the product(s).
 * The {@link lombok.Data}, {@link lombok.NoArgsConstructor} annotations
 * helps to generate the required fields.
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
@Table(name = "product")
public class ProductEntity extends BaseEntity<Long> {

    /**
     * Type of the product.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "type")
    private String type;

    /**
     * Description of the product's fault.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "description")
    private String descrition;

    /**
     * Maintenance of the product.
     * The {@link javax.persistence.OneToOne} defines a single-valued
     * association to another entity that has one-to-one multiplicity.
     * And the {@link OneToOne#mappedBy()} is set with the field
     * that owns the relationship.
     */
    @OneToOne(mappedBy = "product")
    private MaintenanceEntity maintenance;

    /**
     * Brand of the product.
     * With the help of the {@link javax.persistence.ManyToOne} we define a
     * single-valued association to another entity class that
     * has many-to-one multiplicity.
     */
    @ManyToOne
    private BrandEntity brand;

    /**
     * Product owner.
     * With the help of the {@link javax.persistence.ManyToOne} we define a
     * single-valued association to another entity class that
     * has many-to-one multiplicity.
     */
    @ManyToOne
    private ClientEntity client;
}
