/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import decision.GeneratorID;
import decision.ListOfTree;
import decision.Tree;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class ViewTreeController implements Initializable {

    @FXML
    private ToggleGroup paned;
    @FXML
    private ToggleButton trees;
    @FXML
    private TextField question;
    @FXML
    private TextArea description;
    @FXML
    private ListView<Tree> treeList;
    @FXML
    private HBox actionsTreeSelected;

    private Decision decision;
    private ListOfTree listOfTree;
    private Tree treeSelect;
    private ObservableList<Tree> treesItems;
    private GeneratorID generatorID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        actionsTreeSelected.setDisable(true);

        treeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {

                actionsTreeSelected.setDisable(false);
                treeSelect = (Tree) newVal;
            }
        });

    }

    public void start(Decision decision) {

        this.decision = decision;
        listOfTree = this.decision.getUserControl().getSession().getListOfTree();
        generatorID = this.decision.getGeneratorID();
        
        refreshTreesItems();
        

        trees.setSelected(true);
    }
    
    private void refreshTreesItems() {
        
        treesItems = listOfTree.getAllTrees();
        treeList.setItems(treesItems);
        costomCell();
    }

    private void costomCell() {

        treeList.setCellFactory(new Callback<ListView<Tree>, ListCell<Tree>>() {

            @Override
            public ListCell<Tree> call(ListView<Tree> list) {
                return new ListCell<Tree>() {

                    @Override
                    protected void updateItem(Tree item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {

                            Label question = new Label(item.getQuestion());
                            question.getStyleClass().add("tree");
                            Label descriotion = new Label(item.getDescription());

                            VBox itemView = new VBox(10, question, descriotion);
                            setGraphic(itemView);
                        } else {

                            setGraphic(null);
                        }
                    }

                };
            }

        });
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
    private void addTree(ActionEvent event) throws IOException {

        Tree newTree = new Tree(question.getText(), description.getText(), generatorID.getIdTree());

        listOfTree.addTree(newTree);
        
        refreshTreesItems();

        question.clear();
        description.clear();
    }

    @FXML
    private void view(ActionEvent event) {
    }


    @FXML
    private void delete(ActionEvent event) {

        listOfTree.deleteTree(treeSelect);
        
        refreshTreesItems();
        actionsTreeSelected.setDisable(true);
    }

    @FXML
    private void edit(ActionEvent event) {
    }


}
