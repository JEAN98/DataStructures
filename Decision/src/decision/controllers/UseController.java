/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision.controllers;

import decision.Decision;
import decision.Desission;
import decision.Leaf;
import decision.Root;
import decision.Tree;
import decision.TreeNode;
import decision.TreeNodeType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author kenet
 */
public class UseController implements Initializable {

    @FXML
    private Label question;
    @FXML
    private Label description;
    @FXML
    private ListView<TreeNode> questionsList;
    private ObservableList<TreeNode> treesItems;
    private Decision decision;
    private Tree tree;
    private TreeNode questionSelect;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        questionsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {

                questionSelect = (TreeNode) newVal;
            }
        });
    }

    @FXML
    private void back(ActionEvent event) {
        
        treesItems.clear();
        decision.showCatalog();
    }

    @FXML
    private void answer(ActionEvent event) {

        questionsList.getSelectionModel().clearSelection();
        questionSelect = null;
        questionsList.getSelectionModel().selectLast();

        answer(questionSelect);
    }

    private void answer(TreeNode root) {

        if (root != null) {

            if (root.getSelectedNode() != null) {

                treesItems.add(root.getSelectedNode());
            }
        }
    }

    public void start(Tree tree, Decision aThis) {

        this.decision = aThis;
        this.tree = tree;

        question.setText(this.tree.getQuestion());
        description.setText(this.tree.getDescription());

        costomCell();

        treesItems = FXCollections.observableArrayList();
        questionsList.setItems(treesItems);

        treesItems.add(tree.getRoot());
    }

    private void costomCell() {

        questionsList.setCellFactory(new Callback<ListView<TreeNode>, ListCell<TreeNode>>() {

            @Override
            public ListCell<TreeNode> call(ListView<TreeNode> list) {
                return new ListCell<TreeNode>() {

                    private ToggleGroup group;

                    {
                        this.group = new ToggleGroup();
                    }

                    @Override
                    protected void updateItem(TreeNode item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {

                            VBox itemView = new VBox(10);

                            switch (item.getTreeNodeType()) {
                                case Root: {

                                    Root root = (Root) item;

                                    VBox answerView = new VBox(10);

                                    Label title = new Label(root.getQuestion());
                                    title.getStyleClass().addAll("tree");

                                    for (TreeNode child : root.getChilds()) {

                                        RadioButton answer;

                                        if (child.getTreeNodeType() == TreeNodeType.Desission) {

                                            Desission x = (Desission) child;
                                            answer = new RadioButton(x.getAnswer());
                                            answer.setUserData(child);
                                            answer.setToggleGroup(group);
                                            answerView.getChildren().add(answer);
                                        } else {

                                            Leaf x = (Leaf) child;
                                            answer = new RadioButton(x.getAnswer());
                                            answer.setUserData(child);
                                            answer.setToggleGroup(group);
                                            answerView.getChildren().add(answer);
                                        }
                                    }

                                    group.selectedToggleProperty().addListener(new ChangeListener() {
                                        @Override
                                        public void changed(ObservableValue o, Object oldVal, Object newVal) {

                                            RadioButton a = (RadioButton) newVal;
                                            item.setSelectedNode((TreeNode) a.getUserData());
                                        }
                                    });

                                    itemView.getChildren().addAll(title, answerView);

                                    break;
                                }
                                case Desission: {

                                    Desission root = (Desission) item;

                                    VBox answerView = new VBox(10);

                                    Label title = new Label(root.getQuestion());
                                    title.getStyleClass().addAll("tree");

                                    for (TreeNode child : root.getChilds()) {

                                        RadioButton answer;

                                        if (child.getTreeNodeType() == TreeNodeType.Desission) {

                                            Desission x = (Desission) child;
                                            answer = new RadioButton(x.getAnswer());
                                            answer.setUserData(child);
                                            answer.setToggleGroup(group);
                                            answerView.getChildren().add(answer);
                                        } else {

                                            Leaf x = (Leaf) child;
                                            answer = new RadioButton(x.getAnswer());
                                            answer.setUserData(child);
                                            answer.setToggleGroup(group);
                                            answerView.getChildren().add(answer);
                                        }
                                    }

                                    group.selectedToggleProperty().addListener(new ChangeListener() {
                                        @Override
                                        public void changed(ObservableValue o, Object oldVal, Object newVal) {

                                            RadioButton a = (RadioButton) newVal;
                                            item.setSelectedNode((TreeNode) a.getUserData());
                                        }
                                    });

                                    itemView.getChildren().addAll(title, answerView);

                                    break;
                                }
                                case Leaf: {

                                    Leaf root = (Leaf) item;

                                    Label title = new Label(question.getText());
                                    title.getStyleClass().addAll("tree");

                                    Label answer = new Label((root.getAnswerTree()) ? "Yes" : "no");

                                    itemView.getChildren().addAll(title, answer);

                                    break;
                                }
                                default:
                                    break;

                            }

                            setGraphic(itemView);
                        } else {

                            setGraphic(null);
                        }
                    }
                };
            }

        });
    }
}
