package hu.unideb.inf.notebookservice.ui.controller;

import com.jfoenix.controls.JFXButton;
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Product;
import hu.unideb.inf.notebookservice.service.interfaces.ProductService;
import hu.unideb.inf.notebookservice.ui.main.Main;
import hu.unideb.inf.notebookservice.ui.view.LoginView;
import hu.unideb.inf.notebookservice.ui.view.MaintenanceView;
import hu.unideb.inf.notebookservice.ui.view.NewProductView;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class ProductController {

    public TableView<Product> productTable;
    public TableColumn<Product, String> brandTypeColumn;
    public TableColumn<Product, String> typeColumn;
    public TableColumn<Product, String> descriptionColumn;
    public JFXButton logoutButton;
    public Text employeeName;
    public JFXButton addProductButton;
    public Text clientNameField;
    public Text clientEmailField;
    public Text clientPhoneField;
    public Text startDateField;
    public Text endDateField;
    public JFXButton editMaintenanceButton;

    private Employee loggedInEmployee;

    @Autowired
    private NewProductController newProductController;

    @Autowired
    private ProductService productService;

    @Autowired
    private LoginController loginController;

    void init() {
        loggedInEmployee = loginController.getLoginEmployee();
        employeeName.setText(loggedInEmployee.getUsername());

        productTable.getItems().clear();
        configureProductTable();
        for (Product product : productService.listProduct())
            productTable.getItems().add(product);

        productTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> refreshDataPanel(newValue));
    }

    private void configureProductTable() {
        brandTypeColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getBrand().getName()));
        typeColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getType()));
        descriptionColumn.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getDescrition()));
    }

    private void refreshDataPanel(Product product) {
        Product foundProduct = productService.findProduct(product.getId());

        clientNameField.setText(foundProduct.getClient().getFirstName() + " " + product.getClient().getLastName());
        clientEmailField.setText(foundProduct.getClient().getEmail());
        clientPhoneField.setText(foundProduct.getClient().getPhone());
    }

    public void logoutButton(ActionEvent actionEvent) {
        loggedInEmployee = null;

        Main.getStage().setWidth(300);
        Main.getStage().setHeight(400);
        Main.showView(LoginView.class);
    }

    public void addProductButton(ActionEvent actionEvent) {
        Main.showView(NewProductView.class, Modality.APPLICATION_MODAL);
        newProductController.init();
    }


    public void editMaintenanceButton(ActionEvent actionEvent) {
        Main.showView(MaintenanceView.class, Modality.APPLICATION_MODAL);
    }
}
