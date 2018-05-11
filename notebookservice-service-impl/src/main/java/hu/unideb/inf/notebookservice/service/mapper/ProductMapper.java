package hu.unideb.inf.notebookservice.service.mapper;

import hu.unideb.inf.notebookservice.persistence.entity.ProductEntity;
import hu.unideb.inf.notebookservice.service.domain.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to convert {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} entity to
 * {@link hu.unideb.inf.notebookservice.service.domain.Product} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class ProductMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Product} domain object.
     * @param productEntity is the {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.service.domain.Product} object.
     */
    public static Product ProductEntityToProduct(ProductEntity productEntity) {
        return mapper.map(productEntity, Product.class);
    }

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.service.domain.Product} to a
     * lower layered {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} domain object.
     * @param product is the {@link hu.unideb.inf.notebookservice.service.domain.Product} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} object.
     */
    public static ProductEntity ProductToProductEntity(Product product) {
        return mapper.map(product, ProductEntity.class);
    }

    /**
     * This method converts a list of {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Product} domain object list.
     * @param productEntities is a list of {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} to be converted.
     * @return a list of the converted {@link hu.unideb.inf.notebookservice.service.domain.Product} object.
     */
    public static List<Product> ProductEntityToProduct(List<ProductEntity> productEntities) {
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities)
            products.add(ProductEntityToProduct(productEntity));
        return products;

    }

    /**
     * This method converts a list of {@link hu.unideb.inf.notebookservice.service.domain.Product} to a
     * higher layered {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} domain object list.
     * @param products is a list of {@link hu.unideb.inf.notebookservice.service.domain.Product} to be converted.
     * @return a list of the converted {@link hu.unideb.inf.notebookservice.persistence.entity.ProductEntity} object.
     */
    public static List<ProductEntity> ProductToProductEntity(List<Product> products) {
        List<ProductEntity> productEntities = new ArrayList<>();
        for(Product product : products)
            productEntities.add(ProductToProductEntity(product));
        return productEntities;
    }
}
