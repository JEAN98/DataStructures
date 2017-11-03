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

    Decision decision;
    private BorderPane treeView;
    private Object MyTreeViewController;

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

        decision.getRootView().setCenter(treeView);
        searchtextField.setVisible(true);
        searchButtom.setVisible(true);
    }

    @FXML
    private void catalogsTree(ActionEvent event) {

    }

    public void start(Decision decision) {

        this.decision = decision;

        try {
            initUI();
        } catch (IOException ex) {
            Logger.getLogger(TopBarController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initUI() throws IOException {

        //Build login
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/MyTreeView.fxml"));
        this.treeView = (BorderPane) loader.load();

        MyTreeViewController = loader.getController();
    }
}
