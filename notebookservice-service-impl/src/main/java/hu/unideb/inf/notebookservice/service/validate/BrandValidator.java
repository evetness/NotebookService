package hu.unideb.inf.notebookservice.service.validate;

import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.pojo.BrandValidatorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This class help to validate the given {@link hu.unideb.inf.notebookservice.service.domain.Brand}.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class BrandValidator {

    /**
     * The BrandService derives from {@link hu.unideb.inf.notebookservice.service.interfaces.BrandService}.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a client can be reached by via this data member.
     */
    @Autowired
    BrandService brandService;

    /**
     * This method is check if validation is ok.
     * @param brand is the {@link hu.unideb.inf.notebookservice.service.domain.Brand} to be validated.
     * @return a {@link hu.unideb.inf.notebookservice.service.pojo.BrandValidatorPojo} which contains the answer.
     */
    public BrandValidatorPojo regValidator(Brand brand) {

        if(brand.getName().isEmpty())
            return new BrandValidatorPojo(false,"Incorrect Brand name!");
        if(brandService.findByName(brand.getName()) == null)
            return new BrandValidatorPojo(true,"Done!");
        else
            return new BrandValidatorPojo(false,"Brand already exists!");

    }
}
