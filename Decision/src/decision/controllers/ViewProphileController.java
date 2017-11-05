/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import decision.UserControl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class ViewProphileController implements Initializable {
    
    @FXML
    private ToggleGroup paned;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label age;
    @FXML
    private Label sex;
    
    private Decision decision;
    private UserControl userControl;
    @FXML
    private ToggleButton prophile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private void ShowInformation(){
        name.setText(this.userControl.getSession().getFullName());
        id.setText(this.userControl.getSession().getDni());
        age.setText(String.valueOf(this.userControl.getSession().getAge()));
        sex.setText(String.valueOf(this.userControl.getSession().getSex()));
    }
    
    public void start(Decision decision) {
        
        this.decision = decision;
        this.userControl = this.decision.getUserControl();
        prophile.setSelected(true);
        ShowInformation();
    }
    
    @FXML
    private void deleteUser(ActionEvent event) {
        userControl.deleteUser(userControl.getSession().getDni());
        decision.showLogin();
    }
    
    @FXML
    private void viewCatalog(ActionEvent event) {
        decision.showCatalog();
    }
    
    @FXML
    private void logOut(ActionEvent event) {
        
        userControl.closeSession();
        decision.showLogin();
    }
    
    @FXML
    private void viewTrees(ActionEvent event) {
        decision.showTree();
    }
    
}
