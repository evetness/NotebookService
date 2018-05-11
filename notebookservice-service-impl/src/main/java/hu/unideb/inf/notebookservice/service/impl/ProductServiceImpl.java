package hu.unideb.inf.notebookservice.service.impl;

import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.persistence.repository.ProductRepository;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.ProductService;
import hu.unideb.inf.notebookservice.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class manages the product.
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specified {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * The ProductRepository derives from {@link hu.unideb.inf.notebookservice.persistence.repository.ProductRepository}.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a product can be reached by via this data member.
     */
    @Autowired
    ProductRepository productRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the product is stored in the DB with a generated ID.
     * @param product to be added to the database.
     * @return the stored product with its ID.
     */
    @Override
    public Product addProduct(Product product) {

        return ProductMapper.ProductEntityToProduct(
                productRepository.save(ProductMapper.ProductToProductEntity(product)));
    }

    @Override
    public Product findProduct(Long id) {

        Optional<ProductEntity> foundProduct = productRepository.findById(id);

        return ProductMapper.ProductEntityToProduct(foundProduct.get());
    }

    /**
     * In this implementation, with the help of {@link BrandRepository#findAll()} method,
     * all product is queried from the database.
     * @return a list of all product from the database.
     */
    @Override
    public List<Product> listProduct() {

        List<ProductEntity> productList = productRepository.findAll();
        return ProductMapper.ProductEntityToProduct(productList);
    }
}
