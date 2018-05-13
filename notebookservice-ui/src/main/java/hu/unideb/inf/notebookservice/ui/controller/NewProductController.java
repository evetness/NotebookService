package hu.unideb.inf.notebookservice.ui.controller;

/*-
 * #%L
 * NotebookService user interface
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

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.persistence.repository.BrandRepository;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.domain.Client;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.interfaces.ClientService;
import hu.unideb.inf.notebookservice.service.interfaces.MaintenanceService;
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

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    MaintenanceService maintenanceService;

    @Autowired
    ProductValidator productValidator;

    @Autowired
    ProductService productService;

    @Autowired
    ProductController productController;

    @Autowired
    LoginController loginController;

    public void initialize() {
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

    void refreshBrandList() {
        List<Brand> brands = brandService.listBrand();
        ObservableList<String> list = FXCollections.observableArrayList();

        for(Brand brand : brands)
            list.add(brand.getName());
        brandField.setItems(list);
    }

    public void saveButton(ActionEvent actionEvent) {

        Employee employee = loginController.getLoginEmployee();
        Brand brand = brandService.findByName(brandField.getValue());

        Client client = Client.builder()
                .firstName(firstNameField.getText())
                .lastName(lastNameField.getText())
                .email(emailField.getText())
                .phone(phoneField.getText())
                .build();
        ClientValidatorPojo regValidClient = clientValidator.regValidator(client);

        if (regValidClient.isRegistered()) {
            if (clientValidator.uniqueValid(client)) {
                client = clientService.addClient(client);
                messageField.setText(regValidClient.toString());
            } else {
                client = clientService.findByEmail(client.getEmail());

                messageField.setText(regValidClient.toString());
            }

            Product product = Product.builder()
                    .brand(brand)
                    .type(productTypeField.getText())
                    .descrition(descriptionArea.getText())
                    .client(client)
                    .build();
            ProductValidatorPojo regValidProduct = productValidator.regValidator(product);

            if (regValidProduct.isRegistered()) {

                product = productService.addProduct(product);

                Maintenance maintenance = Maintenance.builder()
                        .startDate(LocalDate.now())
                        .endDate(LocalDate.now().plus(2, ChronoUnit.WEEKS))
                        .product(product)
                        .employee(employee)
                        .build();
                maintenanceService.addMaintenance(maintenance);

                messageField.setText(regValidProduct.toString());
            } else {
                messageField.setText(regValidProduct.toString());
            }
        } else {
            messageField.setText(regValidClient.toString());
        }
    }

    public void closeButton(ActionEvent actionEvent) {
        Stage close = (Stage) closeButton.getScene().getWindow();
        close.close();
        productController.initialize();
    }

    public void addBrandButton(ActionEvent actionEvent) {
        Main.showView(BrandView.class, Modality.APPLICATION_MODAL);
        brandController.init();

    }

    public void refreshButton(ActionEvent actionEvent) {
        refreshBrandList();
    }
}
