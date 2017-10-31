/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class Login extends BorderPane {

    @FXML
    private TextField singupFullName;

    @FXML
    private TextField loginDNI;

    @FXML
    private ToggleGroup sex;

    @FXML
    private Button singupButtom;

    @FXML
    private BorderPane root_pane;

    @FXML
    private TextField singupConfirmPassword;

    @FXML
    private Button loginButtom;

    @FXML
    private TextField singupPassword;

    @FXML
    private TextField loginPassword;

    @FXML
    private TextField singupDNI;

    @FXML
    private TextField singupAge;

    @FXML
    private RadioButton singupFemale;

    @FXML
    private RadioButton singupMale;

    public Login() {

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/decision/means/Login.fxml")
        );

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() {
    }

    public void start() {
        loginButtom.requestFocus();
    }
}
