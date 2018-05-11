package hu.unideb.inf.notebookservice.service.mapper;

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class helps to convert {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} entity to
 * {@link hu.unideb.inf.notebookservice.service.domain.Brand} domain or if its needed backwards.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class BrandMapper {

    /**
     * Mapper object that helps convert.
     */
    private static ModelMapper mapper = new ModelMapper();

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Brand} domain object.
     * @param brandEntity is the {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.service.domain.Brand} object.
     */
    public static Brand BrandEntityToBrand(BrandEntity brandEntity) {
        return mapper.map(brandEntity, Brand.class);
    }

    /**
     * This method converts the {@link hu.unideb.inf.notebookservice.service.domain.Brand} to a
     * lower layered {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} domain object.
     * @param brand is the {@link hu.unideb.inf.notebookservice.service.domain.Brand} to be converted.
     * @return the converted {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} object.
     */
    public static BrandEntity BrandToBrandEntity(Brand brand) {
        return mapper.map(brand, BrandEntity.class);
    }

    /**
     * This method converts a list of {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} to a
     * higher layered {@link hu.unideb.inf.notebookservice.service.domain.Brand} domain object list.
     * @param brandEntities is a list of {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} to be converted.
     * @return a list of the converted {@link hu.unideb.inf.notebookservice.service.domain.Brand} object.
     */
    public static List<Brand> BrandEntityToBrand(List<BrandEntity> brandEntities) {
        List<Brand> brands = new ArrayList<>();
        for (BrandEntity brandEntity : brandEntities)
            brands.add(BrandEntityToBrand(brandEntity));
        return brands;
    }

    /**
     * This method converts a list of {@link hu.unideb.inf.notebookservice.service.domain.Brand} to a
     * higher layered {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} domain object list.
     * @param brands is a list of {@link hu.unideb.inf.notebookservice.service.domain.Brand} to be converted.
     * @return a list of the converted {@link hu.unideb.inf.notebookservice.persistence.entity.BrandEntity} object.
     */
    public static List<BrandEntity> BrandToBrandEntity(List<Brand> brands) {
        List<BrandEntity> brandEntities = new ArrayList<>();
        for (Brand brand : brands)
            brandEntities.add(BrandToBrandEntity(brand));
        return brandEntities;
    }

}
