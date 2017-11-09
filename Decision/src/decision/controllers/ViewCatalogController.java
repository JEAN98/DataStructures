/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import decision.Tree;
import decision.User;
import decision.UserControl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author kenma
 */
public class ViewCatalogController implements Initializable {

    @FXML
    private ToggleGroup paned;
    @FXML
    private ToggleButton catalog;
    @FXML
    private ListView<Tree> treeList;
    @FXML
    private Button view;
    @FXML
    private Button use;

    private Decision decision;
    private UserControl userControl;
    private Tree treeSelect;
    private ObservableList<Tree> treesItems;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        use.setDisable(true);
        view.setDisable(true);

        treeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {

                use.setDisable(false);
                view.setDisable(false);
                treeSelect = (Tree) newVal;
            }

        });
    }

    public void start(Decision decision) {

        this.decision = decision;
        userControl = this.decision.getUserControl();

        treesItems = FXCollections.observableArrayList();
        refreshTreesItems();

        catalog.setSelected(true);

    }

    private void refreshTreesItems() {

        User aux = userControl.getRoot();

        while (aux != null) {

            ObservableList<Tree> trees = aux.getListOfTree().getAllTrees();

            if ((aux.getListOfTree() != null) && (trees.size() > 0)) {

                    treesItems.addAll(trees);
            }

            aux = aux.getNext();
        }

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
    private void viewTrees(ActionEvent event) {
        decision.showTree();

    }

    @FXML
    private void view(ActionEvent event) {
        
        decision.showTreeViewCenter(treeSelect, false);
    }

    @FXML
    private void use(ActionEvent event) {
    }

    @FXML
    private void ViewProphile(ActionEvent event) {

        decision.showProphile();
    }

}
