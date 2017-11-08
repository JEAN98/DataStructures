/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import decision.Sex;
import decision.Tester;
import decision.User;
import decision.UserControl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javax.management.openmbean.SimpleType;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class LoginController implements Initializable {

    @FXML
    private BorderPane root_pane;
    @FXML
    private TextField loginDNI;
    @FXML
    private TextField loginPassword;
    @FXML
    private Button loginButtom;
    @FXML
    private TextField singupDNI;
    @FXML
    private TextField singupFullName;
    @FXML
    private TextField singupAge;
    @FXML
    private RadioButton singupMale;
    @FXML
    private ToggleGroup sex;
    @FXML
    private RadioButton singupFemale;
    @FXML
    private TextField singupPassword;
    @FXML
    private TextField singupConfirmPassword;
    @FXML
    private Button singupButtom;

    private Decision decision;
    private UserControl userControl;

    public void start(Decision decision) {

        this.decision = decision;
        this.userControl = this.decision.getUserControl();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void logIn(ActionEvent event) {
        if (verifyInformation()) {
            if (userControl.login(loginDNI.getText(), loginPassword.getText())) {
                cleanInputs();
                decision.showProphile();
            } else {
                Notifications.create()
                        .title("Login")
                        .text("Incorrect ID or password.")
                        .position(Pos.TOP_RIGHT)
                        .showError();
            }
        }
        else{
             Notifications.create()
                        .title("Login")
                        .text("You must fill all inputs!")
                        .position(Pos.TOP_RIGHT)
                        .showError();
        }
    }
    private boolean verifyInformation(){
        if(loginDNI.getText().equals("")|| loginPassword.getText().equals("")){
            return false;
        }
        return true;
    }

    @FXML
    private void SingUp(ActionEvent event) {
        try {
            int x = Integer.valueOf(singupAge.getText());
            if (verifyInpustSingUp()) {
                if (singupPassword.getText().equals(singupConfirmPassword.getText())) {

                    Sex sexUser = null;

                    if (singupMale == this.sex.getSelectedToggle()) {

                        sexUser = Sex.Male;
                    } else {

                        sexUser = Sex.Female;
                    }

                    User newUser = new User(
                            singupFullName.getText(),
                            singupDNI.getText(),
                            Short.parseShort(singupAge.getText()),
                            sexUser,
                            singupPassword.getText()
                    );

                    userControl.addUser(newUser);

                    Notifications.create()
                            .title("Sing Up")
                            .text("Successful registration.")
                            .position(Pos.TOP_RIGHT)
                            .showConfirm();
                    cleanInputs();
                } else {

                    Notifications.create()
                            .title("Sing Up")
                            .text("Passwords do not match.")
                            .position(Pos.TOP_RIGHT)
                            .showError();
                }
            } else {
                Notifications.create()
                        .title("SingUp")
                        .text("You must fill all inputs!")
                        .position(Pos.TOP_RIGHT)
                        .showError();
            }
        } catch (Exception ex) {
            Notifications.create()
                    .title("SingUp")
                    .text("You must write only numbers in the age input!")
                    .position(Pos.TOP_RIGHT)
                    .showError();
        }

    }
    private Boolean verifyInpustSingUp(){
        if (singupFullName.getText().equals("") || singupDNI.getText().equals("") || singupAge.getText().equals("") || singupPassword.getText().equals("")) {
            return false;
        }
        return true;
    }
    
    private void cleanInputs(){
        singupAge.setText("");
        singupDNI.setText("");
        singupAge.setText("");
        singupPassword.setText("");
        singupFullName.setText("");
        loginDNI.setText("");
        loginPassword.setText("");
    }
            
    
       
}
