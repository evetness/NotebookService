package hu.unideb.inf.notebookservice.service.interfaces;

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

import hu.unideb.inf.notebookservice.service.domain.Client;

/**
 * Interface that describes the management of the clients.
 */
public interface ClientService {

    /**
     * This service is adding new client to the database.
     * @param client to be added to the database.
     * @return the persisted database client.
     */
    Client addClient(Client client);

    /**
     * This service handles the search for the client
     * by its email address in the database.
     * @param email of the client.
     * @return the client from the database.
     */
    Client findByEmail(String email);
}
