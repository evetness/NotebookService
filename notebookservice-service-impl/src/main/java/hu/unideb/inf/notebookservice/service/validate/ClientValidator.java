package hu.unideb.inf.notebookservice.service.validate;

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

import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.interfaces.ClientService;
import hu.unideb.inf.notebookservice.service.pojo.ClientValidatorPojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class help to validate the given {@link Client}.
 * The {@link org.springframework.stereotype.Component} indicates that
 * an annotated class is a "component".
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Component
public class ClientValidator {

    /**
     * The ClientService derives from {@link ClientService}.
     * This data member is wired with the help of
     * {@link org.springframework.beans.factory.annotation.Autowired}
     * annotation, by Spring.
     * The needful operations of a client can be reached
     * by via this data member.
     */
    @Autowired
    private ClientService clientService;

    /**
     * This method is check if validation for registering the client is ok.
     * @param client is the {@link Client} to be validated.
     * @return a {@link ClientValidatorPojo} which contains the answer.
     */
    public final ClientValidatorPojo regValidator(final Client client) {

        log.info(">> validate: [client:{}]", client);
        ClientValidatorPojo correct = correctValid(client);

        if (correct.isRegistered()) {
            log.info("<< valid: [client:{}]", client);
            return new ClientValidatorPojo(true, correct.getMessage());
        } else {
            log.info("<< not valid: [client:{}]", client);
            return new ClientValidatorPojo(false, correct.getMessage());
        }
    }

    /**
     * This method is check if the client email is unique.
     * @param client is the {@link Client} to be validated.
     * @return true is email is unique.
     */
    public final boolean uniqueValid(final Client client) {

        if (clientService.findByEmail(client.getEmail()) == null) {
            log.info(">> unique: [client:{}]", client);
            return true;
        } else {
            log.info("<< not unique: [client:{}]", client);
            return false;
        }
    }

    /**
     * This method is check if the client data is correct.
     * @param client is the {@link Client} to be validated.
     * @return a {@link ClientValidatorPojo} which contains the answer.
     */
    private ClientValidatorPojo correctValid(final Client client) {

        List<String> message = new ArrayList<>();
        boolean ok = true;

        if (client.getFirstName().isEmpty()) {
            log.info("<< not valid: [fist name:{}]", client.getFirstName());
            message.add("First name should not be blank!");
            ok = false;
        }

        if (client.getLastName().isEmpty()) {
            log.info("<< not valid: [last name:{}]", client.getLastName());
            message.add("Last name should not be blank!");
            ok = false;
        }

        if (client.getEmail().isEmpty()) {
            log.info("<< not valid: [email:{}]", client.getEmail());
            message.add("Email should not be blank!");
            ok = false;
        } else if (!client.getEmail().contains("@")) {
            log.info("<< not valid: [email:{}]", client.getEmail());
            message.add("Email must contain an @!");
            ok = false;
        }

        if (client.getPhone().isEmpty()) {
            log.info("<< not valid: [phone:{}]", client.getPhone());
            message.add("Phone number should not be blank!");
            ok = false;
        }
        if (ok) {
            return new ClientValidatorPojo(true, message);
        } else {
            return new ClientValidatorPojo(false, message);
        }
    }
}
