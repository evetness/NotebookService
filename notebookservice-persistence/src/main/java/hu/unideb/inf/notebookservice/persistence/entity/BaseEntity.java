package hu.unideb.inf.notebookservice.persistence.entity;

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
