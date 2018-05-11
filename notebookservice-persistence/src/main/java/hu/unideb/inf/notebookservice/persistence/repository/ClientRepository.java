package hu.unideb.inf.notebookservice.persistence.repository;

import hu.unideb.inf.notebookservice.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository of the client, that communicates with the database.
 * The {@link org.springframework.stereotype.Repository} indicates
 * that the annotated class is a repository.
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    /**
     * Searches through the Client table for the client by its first name.
     * @param firstName is the first name of the client.
     * @return It returns the client by the first name.
     */
    ClientEntity findByFirstName(String firstName);

    /**
     * Searches through the Client table for the client by its last name.
     * @param lastName is the last name of the client.
     * @return It returns the client by the last name.
     */
    ClientEntity findByLastName(String lastName);

    /**
     * Searches through the Client table for the client by its email.
     * @param email is the e-mail address of the client.
     * @return It returns the client by e-mail address.
     */
    ClientEntity findByEmail(String email);

    /**
     * Searches through the Client table for the client by its phone.
     * @param phone is the phone number of the client.
     * @return It returns the client by phone number.
     */
    ClientEntity findByPhone(String phone);
}
