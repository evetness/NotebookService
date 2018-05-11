package hu.unideb.inf.notebookservice.service.test;

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import hu.unideb.inf.notebookservice.persistence.entity.ClientEntity;
import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import hu.unideb.inf.notebookservice.persistence.repository.ProductRepository;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.impl.ProductServiceImpl;
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

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Spy
    @InjectMocks
    private ProductServiceImpl productService;

    private static ProductEntity productA;

    private static ProductEntity productB;

    @BeforeClass
    public static void setUpClass() {

        ProductEntity testProductA = new ProductEntity();
        testProductA.setId(1L);
        testProductA.setBrand(new BrandEntity());
        testProductA.setType("ProductTypeA");
        testProductA.setMaintenance(new MaintenanceEntity());
        testProductA.setDescrition("ProductDescriptionA");
        testProductA.setClient(new ClientEntity());

        productA = testProductA;

        ProductEntity testProductB = new ProductEntity();
        testProductB.setId(2L);
        testProductB.setBrand(new BrandEntity());
        testProductB.setType("ProductTypeB");
        testProductB.setMaintenance(new MaintenanceEntity());
        testProductB.setDescrition("ProductDescriptionB");
        testProductB.setClient(new ClientEntity());

        productB = testProductB;
    }

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(productRepository.save(Mockito.any(ProductEntity.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((ProductEntity) args[0]).getId() == null) {
                        ((ProductEntity) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(productRepository.findAll())
                .thenAnswer(invocation -> Arrays.asList(productA, productB));

        Mockito.when(productRepository.findByType(Mockito.anyString()))
                .thenAnswer(invocation -> {
                            Object[] args = invocation.getArguments();
                            if((args[0]).equals(productA.getType()))
                                return productA;
                            else if((args[0]).equals(productB.getType()))
                                return productB;
                            else
                                return null;
                        }
                );

    }

    @Test
    public void addBrandTest() {
        Assert.assertNotNull(productRepository);

        Product newProduct = new Product();
        newProduct.setBrand(new Brand());
        newProduct.setClient(new Client());
        newProduct.setMaintenance(new Maintenance());
        newProduct.setType("testTypeA");
        newProduct.setDescrition("testDescription");

        Product saveProduct = productService.addProduct(newProduct);

        Assert.assertNotNull(saveProduct);
        Assert.assertNotNull(saveProduct.getId());
        Assert.assertNull(saveProduct.getBrand());
        Assert.assertNull(saveProduct.getClient());
        Assert.assertNotNull(saveProduct.getMaintenance());
        Assert.assertNotNull(saveProduct.getType());
        Assert.assertNotNull(saveProduct.getDescrition());
    }

    @Test
    public void findByNameTest() {
        Assert.assertNotNull(productRepository);
        ProductEntity testBrand = productRepository.findByType("ProductTypeA");

        Assert.assertNotNull(testBrand);
        Assert.assertEquals("ProductTypeA",productA.getType());
        Assert.assertNotEquals("ProductTypeB", productA.getType());

    }

    @Test
    public void listBrandTest() {
        Assert.assertNotNull(productRepository);
        List<ProductEntity> productList = productRepository.findAll();

        Assert.assertNotNull(productList);
        Assert.assertEquals(2,productList.size());

    }

}