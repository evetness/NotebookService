package hu.unideb.inf.notebookservice.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.interfaces.ClientService;
import hu.unideb.inf.notebookservice.service.interfaces.ProductService;
import hu.unideb.inf.notebookservice.service.pojo.ClientValidatorPojo;
import hu.unideb.inf.notebookservice.service.pojo.ProductValidatorPojo;
import hu.unideb.inf.notebookservice.service.validate.ClientValidator;
import hu.unideb.inf.notebookservice.service.validate.ProductValidator;
import hu.unideb.inf.notebookservice.ui.main.Main;
import hu.unideb.inf.notebookservice.ui.view.BrandView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FXMLController
public class NewProductController {

    public JFXComboBox<String> brandField;

    public JFXTextField productTypeField;

    public JFXTextArea descriptionArea;

    public JFXTextField firstNameField;

    public JFXTextField lastNameField;

    public JFXTextField emailField;

    public JFXTextField phoneField;

    public JFXButton saveButton;

    public JFXButton closeButton;

    public JFXButton addBrandButton;

    public JFXButton refreshButton;

    public Label messageField;

    @Autowired
    BrandService brandService;

    @Autowired
    BrandController brandController;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientValidator clientValidator;

    @Autowired
    ProductValidator productValidator;

    @Autowired
    ProductService productService;

    @Autowired
    ProductController productController;

    void init() {
        clearData();
        refreshBrandList();
    }

    private void clearData() {
        brandField.setItems(null);
        productTypeField.setText("");
        descriptionArea.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        phoneField.setText("");
        messageField.setText("");
    }

    private void refreshBrandList() {
        List<Brand> brands = brandService.listBrand();
        ObservableList<String> list = FXCollections.observableArrayList();

        for(Brand brand : brands)
            list.add(brand.getName());
        brandField.setItems(list);
    }

    public void saveButton(ActionEvent actionEvent) {

        Client client = Client.builder()
                .firstName(firstNameField.getText())
                .lastName(lastNameField.getText())
                .email(emailField.getText())
                .phone(phoneField.getText())
                .build();

        ClientValidatorPojo regValidClient = clientValidator.regValidator(client);

        if (regValidClient.isRegistered()) {
            clientService.addClient(client);
            messageField.setText(regValidClient.toString());
        } else {
            messageField.setText(regValidClient.toString());
        }

        Brand brand = brandService.findByName(brandField.getValue());
        client = clientService.findByEmail(client.getEmail());

        Product product = Product.builder()
                .brand(brand)
                .type(productTypeField.getText())
                .descrition(descriptionArea.getText())
                .client(client)
                .build();

        ProductValidatorPojo regValidProduct = productValidator.regValidator(product);

        if (regValidProduct.isRegistered()) {
            productService.addProduct(product);
            messageField.setText(regValidProduct.toString());
        } else {
            messageField.setText(regValidProduct.toString());
        }
    }

    public void closeButton(ActionEvent actionEvent) {
        Stage close = (Stage) closeButton.getScene().getWindow();
        close.close();
        productController.init();
    }

    public void addBrandButton(ActionEvent actionEvent) {
        Main.showView(BrandView.class, Modality.APPLICATION_MODAL);
    }

    public void refreshButton(ActionEvent actionEvent) {
    }
}
