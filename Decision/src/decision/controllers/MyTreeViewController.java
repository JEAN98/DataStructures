/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.PopOver;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class MyTreeViewController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private VBox containerTree;
    private VBox popover;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            loadUiPopover();
        } catch (IOException ex) {
            Logger.getLogger(MyTreeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addTree(ActionEvent event) {
        PopOver popOver = new PopOver(this.popover);
        popOver.setArrowLocation(PopOver.ArrowLocation.BOTTOM_LEFT);
        popOver.show(addButton);
    }

    private void loadUiPopover() throws IOException {
        //Build login
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/AddTreePopover.fxml"));
        this.popover = (VBox) loader.load();

//        MyTreeViewController = loader.getController();
    }

}
