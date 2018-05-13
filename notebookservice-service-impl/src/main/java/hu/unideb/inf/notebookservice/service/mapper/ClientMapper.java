package hu.unideb.inf.notebookservice.service.mapper;

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
import hu.unideb.inf.notebookservice.service.domain.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class helps to convert {@link ClientEntity} entity to
 * {@link Client} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 */
@Component
public class ClientMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link ClientEntity} to a
     * higher layered {@link Client} domain object.
     * @param clientEntity is the {@link ClientEntity} to be converted.
     * @return the converted {@link Client} object.
     */
    public static Client clientEntityToClient(final ClientEntity clientEntity) {
        return mapper.map(clientEntity, Client.class);
    }

    /**
     * This method converts the {@link Client} to a
     * lower layered {@link ClientEntity} domain object.
     * @param client is the {@link Client} to be converted.
     * @return the converted {@link ClientEntity} object.
     */
    public static ClientEntity clientToClientEntity(final Client client) {
        return mapper.map(client, ClientEntity.class);
    }

}
