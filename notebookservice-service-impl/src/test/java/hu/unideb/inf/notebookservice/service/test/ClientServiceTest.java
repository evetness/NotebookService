package hu.unideb.inf.notebookservice.service.test;

import hu.unideb.inf.notebookservice.persistence.entity.ClientEntity;
import hu.unideb.inf.notebookservice.persistence.repository.ClientRepository;
import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.impl.ClientServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Spy
    @InjectMocks
    private ClientServiceImpl clientService;

    private static ClientEntity clientA;

    private static ClientEntity clientB;

    @BeforeClass
    public static void setUpClass() {

        ClientEntity testClientA = new ClientEntity();
        testClientA.setId(1L);
        testClientA.setFirstName("ClientFirstA");
        testClientA.setLastName("ClientLastA");
        testClientA.setEmail("ClientEmailA");
        testClientA.setPhone("ClientPhoneA");
        testClientA.setProduct(new ArrayList<>());

        clientA = testClientA;

        ClientEntity testClientB = new ClientEntity();
        testClientB.setId(1L);
        testClientB.setFirstName("ClientFirstB");
        testClientB.setLastName("ClientLastB");
        testClientB.setEmail("ClientEmailB");
        testClientB.setPhone("ClientPhoneB");
        testClientB.setProduct(new ArrayList<>());

        clientB = testClientB;
    }

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(clientRepository.save(Mockito.any(ClientEntity.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((ClientEntity) args[0]).getId() == null) {
                        ((ClientEntity) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(clientRepository.findByEmail(Mockito.anyString()))
                .thenAnswer(invocation -> {
                            Object[] args = invocation.getArguments();
                            if((args[0]).equals(clientA.getEmail()))
                                return clientA;
                            else if((args[0]).equals(clientB.getEmail()))
                                return clientB;
                            else
                                return null;
                        }
                );
    }

    @Test
    public void addClient() {
        Assert.assertNotNull(clientRepository);
        Assert.assertNotNull(clientService);

        Client newClient = new Client();
        newClient.setFirstName("testFirstName");
        newClient.setLastName("testLastName");
        newClient.setEmail("testEmail");
        newClient.setPhone("testPhone");
        newClient.setProducts(Collections.singletonList(new Product()));

        Client saveClient = clientService.addClient(newClient);

        Assert.assertNotNull(saveClient);
        Assert.assertNotNull(saveClient.getId());
        Assert.assertNotNull(saveClient.getFirstName());
        Assert.assertNotNull(saveClient.getLastName());
        Assert.assertNotNull(saveClient.getEmail());
        Assert.assertNotNull(saveClient.getPhone());
        Assert.assertNull(saveClient.getProducts());
    }

    @Test
    public void findByEmail() {
        Assert.assertNotNull(clientRepository);
        ClientEntity testClient = clientRepository.findByEmail("ClientEmailA");

        Assert.assertNotNull(testClient);
        Assert.assertNotNull(testClient.getId());
        Assert.assertNotNull(testClient.getFirstName());
        Assert.assertNotNull(testClient.getLastName());
        Assert.assertNotNull(testClient.getEmail());
        Assert.assertNotNull(testClient.getPhone());
        Assert.assertNotNull(testClient.getProduct());

    }

}
