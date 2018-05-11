package hu.unideb.inf.notebookservice.persistence.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Client entity which represents the clients.
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
@Table(name = "client")
public class ClientEntity extends BaseEntity<Long> {

    /**
     * First name of the Client.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Last name of the Client.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * E-mail address of the Client.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "email")
    private String email;

    /**
     * Phonen number of the Client.
     * {@link Column#name()} sets the name of the column.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * A list of products owned by a Client.
     * The {@link javax.persistence.OneToMany} help to define many-valued
     * association with one-to-many multiplicity, The operations that must be
     * cascaded with persist to the target of the association, this is helped
     * by {@link OneToMany#cascade()}.
     * And the {@link OneToMany#mappedBy()} is set with the field that owns
     * the relationship.
     */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    private List<ProductEntity> product;
}
