/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class TopBarController implements Initializable {

    @FXML
    private BorderPane root_pane;
    @FXML
    private Button backButtom;
    @FXML
    private ToggleButton profileButtom;
    @FXML
    private ToggleGroup MenuTop;
    @FXML
    private ToggleButton treesButtom;
    @FXML
    private ToggleButton catalogsButtom;
    @FXML
    private TextField searchtextField;
    @FXML
    private Button searchButtom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }    

    @FXML
    private void search(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void profile(ActionEvent event) {
    }

    @FXML
    private void myTrees(ActionEvent event) {
    }

    @FXML
    private void catalogsTree(ActionEvent event) {
    }
    
}
