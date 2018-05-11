package hu.unideb.inf.notebookservice.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.felixroske.jfxsupport.FXMLController;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.interfaces.EmployeeService;
import hu.unideb.inf.notebookservice.service.pojo.EmployeeValidatorPojo;
import hu.unideb.inf.notebookservice.service.validate.EmployeeValidator;
import hu.unideb.inf.notebookservice.ui.main.Main;
import hu.unideb.inf.notebookservice.ui.view.ProductView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class LoginController {

    public JFXTextField usernameField;

    public JFXPasswordField passwordField;

    public JFXButton loginButton;

    public JFXButton registerButton;

    public Text errorField;

    private Employee employee;

    @Autowired
    private ProductController productController;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeValidator employeeValidator;

    public void loginButton(ActionEvent actionEvent) {

        employee = Employee.builder()
                .username(usernameField.getText())
                .password(passwordField.getText())
                .build();

        EmployeeValidatorPojo loginValidEmployee = employeeValidator.loginValidator(employee);

        if(loginValidEmployee.isRegistered()) {

            Main.getStage().setWidth(900);
            Main.getStage().setHeight(700);
            Main.showView(ProductView.class);
            productController.init();
        } else
            errorField.setText(loginValidEmployee.getMessage().toString());
    }

    public void registerButton(ActionEvent actionEvent) {

        employee = Employee.builder()
                .username(usernameField.getText())
                .password(passwordField.getText())
                .build();

        EmployeeValidatorPojo regValidEmployee = employeeValidator.regValidator(employee);

        if(regValidEmployee.isRegistered()) {
            employeeService.addEmployee(employee);
            errorField.setText(regValidEmployee.getMessage().toString());
        } else {
            errorField.setText(regValidEmployee.getMessage().toString());
        }
    }

    Employee getLoginEmployee() {
        return employee;
    }
}
