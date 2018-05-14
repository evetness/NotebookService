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

    private Employee loginEmployee;

    Employee getLoginEmployee() {
        return loginEmployee;
    }

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

            loginEmployee = employeeService.findByUsername(employee.getUsername());

            Main.getStage().setWidth(900);
            Main.getStage().setHeight(700);
            Main.showView(ProductView.class);
            productController.initialize();

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
            loginEmployee = employeeService.addEmployee(employee);
            errorField.setText(regValidEmployee.toString());
        } else {
            errorField.setText(regValidEmployee.toString());
        }
    }

}
