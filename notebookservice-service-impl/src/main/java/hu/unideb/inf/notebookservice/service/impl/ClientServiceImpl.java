package hu.unideb.inf.notebookservice.service.impl;

/*-
 * #%L
 * NotebookService Implementation
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
import hu.unideb.inf.notebookservice.persistence.repository.ClientRepository;
import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.interfaces.ClientService;
import hu.unideb.inf.notebookservice.service.mapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class manages the client. This class is annotated by
 * {@link org.springframework.stereotype.Service Service}, it is a more
 * specified {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    /**
     * The ClientRepository derives from {@link ClientRepository}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring. The needful operations of a client
     * can be reached by via this data member.
     */
    @Autowired
    private ClientRepository clientRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the client is stored in the DB with a generated ID.
     * @param client to be added to the database.
     * @return the stored client with its ID.
     */
    @Override
    public final Client addClient(final Client client) {
        log.info(">> add: [client:{}]", client);
        return ClientMapper.clientEntityToClient(
                clientRepository.save(
                        ClientMapper.clientToClientEntity(client)));
    }

    /**
     * In this implementation, with the help of
     * {@link ClientRepository#findByEmail(String)} method,
     * the client is queried from the database.
     * @param email of the client.
     * @return the desired client by its name from the database.
     */
    @Override
    public final Client findByEmail(final String email) {
        log.info(">> findByEmail: [email:{}]", email);
        ClientEntity foundClient = clientRepository.findByEmail(email);

        if (foundClient == null) {
            log.info("<< findByEmail: [email:{}]", email);
            return null;
        } else {
            log.info("<< findByEmail: [email:{}]", email);
            return ClientMapper.clientEntityToClient(foundClient);
        }
    }
}
