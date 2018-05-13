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
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.interfaces.MaintenanceService;
import hu.unideb.inf.notebookservice.ui.main.Main;
import hu.unideb.inf.notebookservice.ui.view.LoginView;
import hu.unideb.inf.notebookservice.ui.view.MaintenanceView;
import hu.unideb.inf.notebookservice.ui.view.NewProductView;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@FXMLController
public class ProductController {

    public TableView<Maintenance> productTable;
    public TableColumn<Maintenance, String> brandTypeColumn;
    public TableColumn<Maintenance, String> typeColumn;
    public TableColumn<Maintenance, String> descriptionColumn;
    public JFXButton logoutButton;
    public Text employeeName;
    public JFXButton addProductButton;
    public Label clientNameField;
    public Label clientEmailField;
    public Label clientPhoneField;
    public Label startDateField;
    public Label endDateField;
    public Label faultsField;
    public Label modificationField;
    public JFXButton editMaintenanceButton;
    public Label priceField;
    public Text currentDate;

    private Employee loggedInEmployee;

    private Maintenance foundMaintenance;

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private LoginController loginController;

    @Autowired
    private NewProductController newProductController;

    @Autowired
    private MaintenanceController maintenanceController;

    public void initialize() {

        loggedInEmployee = loginController.getLoginEmployee();
        employeeName.setText(loggedInEmployee.getUsername());
        currentDate.setText(String.valueOf(LocalDate.now()));
        refresh();
    }

    private void refresh() {
        configureProductTable();
        for (Maintenance maintenance : maintenanceService.findByEmployee(loggedInEmployee))
            productTable.getItems().add(maintenance);

        productTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> refreshDataPanel(newValue));
    }

    private void configureProductTable() {
        productTable.getItems().clear();
        brandTypeColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getProduct().getBrand().getName()));
        typeColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getProduct().getType()));
        descriptionColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getProduct().getDescrition()));
    }

    private void refreshDataPanel(Maintenance maintenance) {
        if (maintenance != null) {
            foundMaintenance = maintenanceService.findById(maintenance.getId());

            clientNameField.setText(foundMaintenance.getProduct().getClient().getFirstName()
                    + " " +
                    foundMaintenance.getProduct().getClient().getLastName());
            clientEmailField.setText(foundMaintenance.getProduct().getClient().getEmail());
            clientPhoneField.setText(foundMaintenance.getProduct().getClient().getPhone());
            startDateField.setText(foundMaintenance.getStartDate().toString());
            endDateField.setText(foundMaintenance.getEndDate().toString());
            faultsField.setText(foundMaintenance.getFaults());
            modificationField.setText(foundMaintenance.getModification());
            priceField.setText(String.valueOf(foundMaintenance.getPrice()));
        }
    }

    public void logoutButton(ActionEvent actionEvent) {
        loggedInEmployee = null;

        Main.getStage().setWidth(300);
        Main.getStage().setHeight(400);
        Main.showView(LoginView.class);
    }

    public void addProductButton(ActionEvent actionEvent) {
        Main.showView(NewProductView.class, Modality.APPLICATION_MODAL);
        newProductController.initialize();
    }

    public void editMaintenanceButton(ActionEvent actionEvent) {

        if (foundMaintenance != null) {
            Main.showView(MaintenanceView.class, Modality.APPLICATION_MODAL);
            initialize();
        } else {
            modificationField.setText("Select Product!");
        }
    }

    public void refreshButton(ActionEvent actionEvent) {
        refresh();
    }

    public void exitButton(ActionEvent actionEvent) {
        Main.getStage().close();
    }

    Maintenance getFoundMaintenance() {
        return foundMaintenance;
    }
}
