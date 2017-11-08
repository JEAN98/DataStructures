/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import decision.Tree;
import decision.TreeNode;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author kenet
 */
public class EditTreeController implements Initializable {

    @FXML
    private HBox actionsTreeSelected;
    @FXML
    private ToggleGroup Nodes;
    @FXML
    private VBox paneEditNode;
    @FXML
    private TreeView<TreeNode> tree;

    private Tree treeControl;
    @FXML
    private Label question;
    @FXML
    private Label description;
    private Decision decision;
    private VBox nodeRoot;
    private Object nodeRootController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void start(Tree tree, Decision decision) {

        this.treeControl = tree;
        this.decision = decision;
        question.setText(treeControl.getQuestion());
        description.setText(treeControl.getDescription());
    }

    @FXML
    private void back(ActionEvent event) {

        decision.showTree();
    }

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void root(ActionEvent event) {
        
        paneEditNode = nodeRoot;
    }

    @FXML
    private void decision(ActionEvent event) {
    }

    @FXML
    private void leaft(ActionEvent event) {
    }

    private void initUI(){
        
        
        //Build catalog
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/EditTree.fxml"));
        try {
            this.nodeRoot = (VBox) loader.load();
        } catch (IOException ex) {
            Logger.getLogger(EditTreeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        nodeRootController = loader.getController();
    
    }
}
