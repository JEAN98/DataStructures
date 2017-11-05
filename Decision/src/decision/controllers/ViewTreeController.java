/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class ViewTreeController implements Initializable {

    @FXML
    private ToggleGroup paned;
    private Decision decision;
    @FXML
    private ToggleButton trees;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void start(Decision decision) {

        this.decision = decision;
        trees.setSelected(true);

    }

    @FXML
    private void deleteUser(ActionEvent event) {
    }

    @FXML
    private void ViewProphile(ActionEvent event) {

        decision.showProphile();
    }

    @FXML
    private void viewCatalog(ActionEvent event) {
        decision.showCatalog();

    }

    @FXML
    private void logOut(ActionEvent event) {
    }

}
