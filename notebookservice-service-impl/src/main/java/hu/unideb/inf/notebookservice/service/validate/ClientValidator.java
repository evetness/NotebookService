package hu.unideb.inf.notebookservice.service.validate;

import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.interfaces.ClientService;
import hu.unideb.inf.notebookservice.service.pojo.ClientValidatorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class help to validate the given {@link hu.unideb.inf.notebookservice.service.domain.Client}.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class ClientValidator {

    /**
     * The ClientService derives from {@link hu.unideb.inf.notebookservice.service.interfaces.ClientService}.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a client can be reached by via this data member.
     */
    @Autowired
    ClientService clientService;

    /**
     * This method is check if validation is ok.
     * @param client is the {@link hu.unideb.inf.notebookservice.service.domain.Client} to be validated.
     * @return a {@link hu.unideb.inf.notebookservice.service.pojo.ClientValidatorPojo} which contains the answer.
     */
    public ClientValidatorPojo regValidator(Client client) {

        List<String> message = new ArrayList<>();
        boolean ok = true;

        if (client.getFirstName().isEmpty()) {
            message.add("First name should not be blank!");
            ok = false;
        }

        if (client.getLastName().isEmpty()) {
            message.add("Last name should not be blank!");
            ok = false;
        }

        if (client.getEmail().isEmpty()) {
            message.add("Email should not be blank!");
            ok = false;
        } else if (!client.getEmail().contains("@")) {
            message.add("Email must contain an @!");
            ok = false;
        }

        if (client.getPhone().isEmpty()) {
            message.add("Phone number should not be blank!");
            ok = false;
        }

        if (ok) {
            if(clientService.findByEmail(client.getEmail()) == null) {
                message.add("Successful!");
                return new ClientValidatorPojo(true, message);
            } else {
                message.add("Client is already in the database!");
                return new ClientValidatorPojo(false, message);
            }
        } else {
            return new ClientValidatorPojo(false,message);
        }





    }
}
