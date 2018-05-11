package hu.unideb.inf.notebookservice.service.impl;

import hu.unideb.inf.notebookservice.persistence.entity.BrandEntity;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.mapper.BrandMapper;
import hu.unideb.inf.notebookservice.service.validate.BrandValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class manages the brands..
 * This class is annotated by {@link org.springframework.stereotype.Service Service},
 * it is a more specified {@link org.springframework.stereotype.Component Component}.
 * {@link lombok.extern.slf4j.Slf4j} is needed for logging.
 */
@Slf4j
@Service
public class BrandServiceImpl implements BrandService {

    /**
     * The BrandRepository derives from {@link hu.unideb.inf.notebookservice.persistence.repository.BrandRepository}.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a brand can be reached by via this data member.
     */
    @Autowired
    private BrandRepository brandRepository;

    /**
     * In this implementation, in the method with the help of
     * {@link org.springframework.data.repository.CrudRepository#save(Object)}
     * method, the brand is stored in the DB with a generated ID.
     * @param brand to be added to the database.
     * @return the stored brand with its ID.
     */
    @Override
    public Brand addBrand(Brand brand) {

        return BrandMapper.BrandEntityToBrand(
                brandRepository.save(BrandMapper.BrandToBrandEntity(brand)));
    }

    /**
     * In this implementation, with the help of
     * {@link hu.unideb.inf.notebookservice.persistence.repository.BrandRepository#findByName(String)} method,
     * the brand is queried from the database.
     * @param name of the brand.
     * @return the desired brand by its name from the database.
     */
    @Override
    public Brand findByName(String name) {

        BrandEntity foundBrand = brandRepository.findByName(name);

        if(foundBrand == null)
            return null;
        else
            return BrandMapper.BrandEntityToBrand(foundBrand);
    }

    /**
     * This implementation, with the help of {@link CrudRepository#findAll()} method,
     * all brand is queried from the database to a list.
     * @return a list of all brand.
     */
    @Override
    public List<Brand> listBrand() {

        List<BrandEntity> brandList = brandRepository.findAll();
        return BrandMapper.BrandEntityToBrand(brandList);
    }
}
