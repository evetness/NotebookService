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
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.interfaces.MaintenanceService;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class MaintenanceController {

    public Text prodBrandType;
    public Text prodDescription;
    public JFXDatePicker startDatePicker;
    public JFXDatePicker endDatePicker;
    public JFXTextField faultsField;
    public JFXTextField modificationField;
    public JFXButton saveButton;
    public JFXButton closeButton;
    public JFXTextField priceField;

    @Autowired
    MaintenanceService maintenanceService;

    @Autowired
    ProductController productController;

    private Maintenance selected;

    public void initialize() {
        selected = productController.getFoundMaintenance();
        prodBrandType.setText(selected.getProduct().getBrand().getName() + " " + selected.getProduct().getType());
        prodDescription.setText(selected.getProduct().getDescrition());
        startDatePicker.setValue(selected.getStartDate());
        endDatePicker.setValue(selected.getEndDate());
        faultsField.setText(selected.getFaults());
        modificationField.setText(selected.getModification());
        priceField.setText(String.valueOf(selected.getPrice()));
    }

    public void saveButton(ActionEvent actionEvent) {

        Maintenance newMaintenance = Maintenance.builder()
                .id(selected.getId())
                .employee(selected.getEmployee())
                .product(selected.getProduct())
                .startDate(startDatePicker.getValue())
                .endDate(endDatePicker.getValue())
                .faults(faultsField.getText())
                .modification(modificationField.getText())
                .price(Integer.parseInt(priceField.getText()))
                .build();
        maintenanceService.editMaintenance(newMaintenance);
    }

    public void closeButton(ActionEvent actionEvent) {

        Stage close = (Stage) closeButton.getScene().getWindow();
        close.close();
    }

    public void refreshButton(ActionEvent actionEvent) {
        initialize();
    }
}
