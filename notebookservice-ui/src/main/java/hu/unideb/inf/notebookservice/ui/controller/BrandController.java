package hu.unideb.inf.notebookservice.ui.controller;

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
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class BrandController {

    public JFXTextField brandNameField;

    public JFXButton saveButton;

    public Text errorField;

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandValidator brandValidator;

    @Autowired
    private NewProductController newProductController;

    @FXML
    void initialize() {
        brandNameField.setText("");
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

        newProductController.init();
    }
}
