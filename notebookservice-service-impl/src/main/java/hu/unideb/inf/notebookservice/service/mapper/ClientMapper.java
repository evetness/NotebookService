package hu.unideb.inf.notebookservice.service.mapper;

import hu.unideb.inf.notebookservice.persistence.entity.ClientEntity;
import hu.unideb.inf.notebookservice.service.domain.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * This class helps to convert {@link hu.unideb.inf.notebookservice.persistence.entity.ClientEntity} entity to
 * {@link hu.unideb.inf.notebookservice.service.domain.Client} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class ClientMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.persistence.entity.ClientEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Client} domain object.
     * @param clientEntity is the {@link hu.unideb.inf.notebookservice.persistence.entity.ClientEntity} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.service.domain.Client} object.
     */
    public static Client ClientEntityToClient(ClientEntity clientEntity) {
        return mapper.map(clientEntity, Client.class);
    }

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.service.domain.Client} to a
     * lower layered {@link hu.unideb.inf.notebookservice.persistence.entity.ClientEntity} domain object.
     * @param client is the {@link hu.unideb.inf.notebookservice.service.domain.Client} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.persistence.entity.ClientEntity} object.
     */
    public static ClientEntity ClientToClientEntity(Client client) {
        return mapper.map(client, ClientEntity.class);
    }

}
