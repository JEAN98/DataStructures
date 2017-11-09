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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author kenet
 */
public class TreeViewCenterController implements Initializable {

    @FXML
    private Label question;
    @FXML
    private Label description;
    @FXML
    private ToggleGroup View;
    @FXML
    private Label numberOfCombination;
    @FXML
    private Label averageOfSteps;
    @FXML
    private TreeView<TreeNode> treeView;
    private Decision decision;
    private Tree tree;
    private boolean isShowtree;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void back(ActionEvent event) {

        if (isShowtree) {

            decision.showTree();
        } else {

            decision.showCatalog();
        }
    }

    @FXML
    private void showAllCombinations(ActionEvent event) {

        treeView.setRoot(null);

        TreeNode rootNodeTree = tree.getRoot();

        if (rootNodeTree != null) {

            TreeItem<TreeNode> rootNode = new TreeItem<>(rootNodeTree);
            load(rootNodeTree, rootNode);

            treeView.setRoot(rootNode);
            rootNode.setExpanded(true);
        }

    }

    @FXML
    private void showShorter(ActionEvent event) {
    }

    @FXML
    private void showLongest(ActionEvent event) {
    }

    public void start(Tree tree, boolean isShowtree, Decision aThis) {

        this.decision = aThis;
        this.tree = tree;
        this.isShowtree = isShowtree;

        question.setText(this.tree.getQuestion());
        description.setText(this.tree.getDescription());

        showAllCombinations(new ActionEvent());
        costomCell();
        
        numberOfCombination.setText(String.valueOf(this.tree.numberOfCombinations()));
    }

    private void load(TreeNode root, TreeItem<TreeNode> rootItem) {

        if (root.getChildCount() > 0) {
            if (root.getChilds().length > 0) {
                for (TreeNode child : root.getChilds()) {

                    TreeItem<TreeNode> newItem = new TreeItem<>(child);
                    rootItem.getChildren().add(newItem);
                    rootItem.setExpanded(true);
                    load(child, newItem);
                }

            }
        }

    }

    private void costomCell() {

        treeView.setCellFactory(new Callback<TreeView<TreeNode>, TreeCell<TreeNode>>() {

            @Override
            public TreeCell<TreeNode> call(TreeView<TreeNode> tree) {
                return new TreeCell<TreeNode>() {

                    @Override
                    protected void updateItem(TreeNode item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {

                            VBox itemView = new VBox(10);
                            itemView.setPrefSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                            itemView.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
                            itemView.setPadding(new Insets(10));
                            itemView.getStyleClass().addAll("node");

                            if (null != item.getTreeNodeType()) {

                                switch (item.getTreeNodeType()) {
                                    case Root: {

                                        Root root = (Root) item;

                                        Label title = new Label("Root");
                                        title.getStyleClass().addAll("tree", "headerText");

                                        Label question = new Label(root.getQuestion());
                                        question.getStyleClass().addAll("headerText");

                                        itemView.getChildren().addAll(title, question);
                                        itemView.getStyleClass().addAll("root");

                                        break;
                                    }
                                    case Desission: {

                                        Desission decission = (Desission) item;

                                        Label title = new Label("Desicion");
                                        title.getStyleClass().addAll("tree", "headerText");

                                        Label question = new Label(decission.getQuestion());
                                        question.getStyleClass().addAll("headerText");

                                        Label answer = new Label(decission.getAnswer());
                                        answer.getStyleClass().addAll("headerText");

                                        itemView.getChildren().addAll(title, question, answer);
                                        itemView.getStyleClass().addAll("dessicion");

                                        break;
                                    }
                                    case Leaf: {

                                        Leaf leaft = (Leaf) item;

                                        Label title = new Label("Leaf");
                                        title.getStyleClass().addAll("tree", "headerText");

                                        Label answer = new Label(leaft.getAnswer());
                                        answer.getStyleClass().addAll("headerText");

                                        Label answerTree = new Label(leaft.getAnswerTree());
                                        answerTree.getStyleClass().addAll("headerText");

                                        itemView.getChildren().addAll(title, answer, answerTree);
                                        itemView.getStyleClass().addAll("leaft");

                                        break;
                                    }
                                    default:
                                        break;
                                }
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
