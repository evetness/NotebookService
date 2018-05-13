package hu.unideb.inf.notebookservice.service.test;

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

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import hu.unideb.inf.notebookservice.persistence.entity.ClientEntity;
import hu.unideb.inf.notebookservice.persistence.entity.MaintenanceEntity;
import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.impl.BrandServiceImpl;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @Spy
    @InjectMocks
    private BrandServiceImpl brandService;

    private static BrandEntity brandA;

    private static BrandEntity brandB;

    @BeforeClass
    public static void setUpClass() {

        BrandEntity testBrandA = new BrandEntity();
        testBrandA.setId(1L);
        testBrandA.setName("BrandA");
        testBrandA.setProduct(new ArrayList<>());

        brandA = testBrandA;

        BrandEntity testBrandB = new BrandEntity();
        testBrandB.setId(2L);
        testBrandB.setName("BrandB");
        testBrandB.setProduct(new ArrayList<>());

        brandB = testBrandB;
    }

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(brandRepository.save(Mockito.any(BrandEntity.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((BrandEntity) args[0]).getId() == null) {
                        ((BrandEntity) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(brandRepository.findAll())
                .thenAnswer(invocation -> Arrays.asList(brandA, brandB));

        Mockito.when(brandRepository.findByName(Mockito.anyString()))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if((args[0]).equals(brandA.getName()))
                        return brandA;
                    else if((args[0]).equals(brandB.getName()))
                        return brandB;
                    else
                        return null;
                    }
                );

    }

    @Test
    public void addBrandTest() {
        Assert.assertNotNull(brandRepository);

        Brand newBrand = new Brand();
        newBrand.setName("testBrand");
        newBrand.setProducts(Collections.singletonList(new Product()));

        Brand savedBrand = brandService.addBrand(newBrand);

        Assert.assertNotNull(savedBrand);
        Assert.assertNotNull(savedBrand.getId());
        Assert.assertNotNull(savedBrand.getName());
        Assert.assertNull(savedBrand.getProducts());
    }

    @Test
    public void findByNameTest() {
        Assert.assertNotNull(brandRepository);
        BrandEntity testBrand = brandRepository.findByName("BrandA");

        Assert.assertNotNull(testBrand);
        Assert.assertEquals("BrandA",brandA.getName());
        Assert.assertNotEquals("BrandB", brandA.getName());

    }

    @Test
    public void listBrandTest() {
        Assert.assertNotNull(brandRepository);
        List<BrandEntity> brandList = brandRepository.findAll();

        Assert.assertNotNull(brandList);
        Assert.assertEquals(2,brandList.size());

    }

}
