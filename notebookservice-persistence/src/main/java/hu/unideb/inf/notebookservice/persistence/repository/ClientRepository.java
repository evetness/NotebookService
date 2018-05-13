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
