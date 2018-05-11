package hu.unideb.inf.notebookservice.service.validate;

import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.ProductService;
import hu.unideb.inf.notebookservice.service.pojo.ProductValidatorPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class help to validate the given {@link hu.unideb.inf.notebookservice.service.domain.Product}.
 * The {@link org.springframework.stereotype.Component} indicates that an annotated class is a "component".
 */
@Component
public class ProductValidator {

    /**
     * The ProductService derives from {@link hu.unideb.inf.notebookservice.service.interfaces.ProductService}.
     * This data member is wired with the help of {@link org.springframework.beans.factory.annotation.Autowired} annotation, by Spring.
     * The needful operations of a client can be reached by via this data member.
     */
    @Autowired
    ProductService productService;

    public ProductValidatorPojo regValidator(Product product) {

        List<String> message = new ArrayList<>();
        boolean ok = true;

        if (product.getType().isEmpty()) {
            message.add("Type is required!");
            ok = false;
        }
        if (product.getDescrition().isEmpty()) {
            message.add("Description is required!");
            ok = false;
        }

        if (ok) {
            message.add("Success!");
            return new ProductValidatorPojo(true, message);
        } else {
            return new ProductValidatorPojo(false, message);
        }

    }
}
