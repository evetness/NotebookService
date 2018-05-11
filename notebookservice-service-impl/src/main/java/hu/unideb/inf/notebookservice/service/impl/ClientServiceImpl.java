package hu.unideb.inf.notebookservice.service.impl;

import hu.unideb.inf.notebookservice.persistence.entity.ClientEntity;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.persistence.repository.ClientRepository;
import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.interfaces.ClientService;
import hu.unideb.inf.notebookservice.service.mapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class manages the client.
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specified {@link org.springframework.stereotype.Component Component}.
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
    ClientRepository clientRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the client is stored in the DB with a generated ID.
     * @param client to be added to the database.
     * @return the stored client with its ID.
     */
    @Override
    public Client addClient(Client client) {

        return ClientMapper.ClientEntityToClient(
                clientRepository.save(
                        ClientMapper.ClientToClientEntity(client)));
    }

    /**
     * In this implementation, with the help of
     * {@link BrandRepository#findByName(String)} method,
     * the client is queried from the database.
     * @param email of the client.
     * @return the desired client by its name from the database.
     */
    @Override
    public Client findByEmail(String email) {

        ClientEntity foundClient = clientRepository.findByEmail(email);

        if(foundClient == null)
            return null;
        else
            return  ClientMapper.ClientEntityToClient(foundClient);
    }

}
