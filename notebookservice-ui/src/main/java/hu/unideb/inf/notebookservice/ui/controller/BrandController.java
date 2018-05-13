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
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.service.domain.Brand;
import hu.unideb.inf.notebookservice.service.interfaces.BrandService;
import hu.unideb.inf.notebookservice.service.pojo.BrandValidatorPojo;
import hu.unideb.inf.notebookservice.service.validate.BrandValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class BrandController {

    public JFXTextField brandNameField;

    public Text errorField;

    public JFXButton closeButton;

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandValidator brandValidator;

    @Autowired
    private NewProductController newProductController;

    void init() {
        brandNameField.clear();
        errorField.setText("");
    }

    public void saveButton(ActionEvent actionEvent) {

        Brand saveBrand = Brand.builder()
                .name(brandNameField.getText())
                .build();
        BrandValidatorPojo saveValidBrand = brandValidator.regValidator(saveBrand);

        if (saveValidBrand.isRegistered()) {
            brandService.addBrand(saveBrand);
            errorField.setText(saveValidBrand.getMessage());
        }
        else
            errorField.setText(saveValidBrand.getMessage());
    }

    public void closeButton(ActionEvent actionEvent) {

        Stage close = (javafx.stage.Stage) closeButton.getScene().getWindow();
        close.close();

        newProductController.refreshBrandList();
    }
}
