/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.ui;

import decision.Decision;
import decision.Sex;
import decision.User;
import decision.UserControl;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
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

    private Decision decision;
    private UserControl userControl;

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

        singupButtom.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                singUp();
            }
        });

        loginButtom.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                login();
            }
        });

    }

    public void start(Decision decision) {

        this.decision = decision;
        this.userControl = this.decision.getUserControl();
        
        loginButtom.requestFocus();
    }

    private void login() {

        if(userControl.login(loginDNI.getText(), loginPassword.getText())){
        
            System.out.println("Login");
        }
    }

    private void singUp() {
        
        if (singupPassword.getText().equals(singupConfirmPassword.getText())) {
            
            Sex sexUser = null;
            
            if(singupMale == this.sex.getSelectedToggle()){
                
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
            
            System.out.println(sexUser);
            
            userControl.addUser(newUser);
        }
    }
}
