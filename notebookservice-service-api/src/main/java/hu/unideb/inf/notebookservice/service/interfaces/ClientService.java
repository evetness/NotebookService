package hu.unideb.inf.notebookservice.service.interfaces;

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
