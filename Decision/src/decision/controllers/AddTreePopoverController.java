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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class AddTreePopoverController implements Initializable {

    @FXML
    private TextField questionTxt;
    @FXML
    private TextArea descriptionTxt;
    private BorderPane popover;
    private VBox containerTree;

    public void start(VBox containerTree) {
        this.containerTree = containerTree;

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addTree(ActionEvent event) throws IOException {

        //Build login
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/Tree.fxml"));
        BorderPane tree = (BorderPane) loader.load();

        containerTree.getChildren().add(tree);

        TreeController treeController = loader.getController();
        treeController.start(questionTxt.getText(), descriptionTxt.getText());
    }

}
