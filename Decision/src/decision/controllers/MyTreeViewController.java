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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
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
    @FXML
    private ScrollPane scroll;

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
        
        final Timeline timeline = new Timeline();
        final KeyValue kv = new KeyValue(scroll.vvalueProperty(), 1.0f);
        final KeyFrame kf = new KeyFrame(Duration.millis(500), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        
        
        //Build login
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/AddTreePopover.fxml"));
        this.popover = (VBox) loader.load();

        AddTreePopoverController addTreePopoverController = loader.getController();
        addTreePopoverController.start(containerTree);
    }

}
