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
import static decision.TreeNodeType.Desission;
import static decision.TreeNodeType.Root;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author kenet
 */
public class EditTreeController implements Initializable {

    @FXML
    private TreeView<TreeNode> treeView;
    @FXML
    private Label question;
    @FXML
    private Label description;
    @FXML
    private TitledPane rootPane;
    @FXML
    private TextArea questionRoot;
    @FXML
    private TitledPane decisionPane;
    @FXML
    private TextArea answerDecision;
    @FXML
    private TextArea questionDecision;
    @FXML
    private TitledPane leaftPane;
    @FXML
    private TextArea answerLeaft;
    @FXML
    private ToggleGroup answerTree;

    private Decision decision;
    private Tree treeControl;
    private TreeItem<TreeNode> rootNode;
    private TreeItem<TreeNode> selectNode;
    private TreeNode rootNodeTree;
    private boolean haveRoot = false;
    private ArrayList<Boolean> listVerify;
    @FXML
    private RadioButton yesAnswerTree;
    @FXML
    private RadioButton noAnswerTree;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue o, Object oldVal, Object newVal) {

                selectNode = (TreeItem<TreeNode>) newVal;
            }
        });
    }

    public void start(Tree tree, Decision decision) {

        this.treeControl = tree;
        this.decision = decision;

        question.setText(treeControl.getQuestion());
        description.setText(treeControl.getDescription());

        refreshTreesItems();
    }

    private void refreshTreesItems() {

        treeView.setRoot(null);
        haveRoot = false;

        rootNodeTree = treeControl.getRoot();
        if (rootNodeTree != null) {

            this.rootNode = new TreeItem<>(rootNodeTree);
            load(rootNodeTree, rootNode);
            treeView.setRoot(rootNode);
            haveRoot = true;
        } else {

            this.rootNode = new TreeItem<>();
        }

        rootNode.setExpanded(true);
        costomCell();

        uiControl();
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

                                        String s = (leaft.getAnswerTree()) ? "Yes" : "No";
                                        Label answerTree = new Label(s);
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

    private void uiControl() {

        if (haveRoot) {

            rootPane.setExpanded(false);
            rootPane.setDisable(true);

            decisionPane.setExpanded(true);
            decisionPane.setDisable(false);

            leaftPane.setExpanded(true);
            leaftPane.setDisable(false);
        } else {

            rootPane.setExpanded(true);
            rootPane.setDisable(false);

            decisionPane.setExpanded(false);
            decisionPane.setDisable(true);

            leaftPane.setExpanded(false);
            leaftPane.setDisable(true);
        }
    }

    @FXML
    private void back(ActionEvent event) {

        decision.showTree();
    }

    @FXML
    private void save(ActionEvent event) {

        if (treeView.getRoot() != null) {

            TreeNode newNode;
            TreeItem<TreeNode> rootItem = treeView.getRoot();
            newNode = rootItem.getValue();

            if (verify(rootItem)) {

                save(newNode, rootItem);
                treeControl.addRootNode(newNode);
            } else {

                Notifications.create()
                        .title("Save")
                        .text("All branches must end in leaves.")
                        .position(Pos.TOP_RIGHT)
                        .showError();

            }

        }
    }

    private void save(TreeNode rootNode, TreeItem<TreeNode> rootItem) {

        rootNode.setChildCount(rootItem.getChildren().size());

        for (TreeItem<TreeNode> child : rootItem.getChildren()) {

            if (!child.getChildren().isEmpty()) {
                save(child.getValue(), child);
            }

            rootNode.addNode(child.getValue());
        }
    }

    private void verifyAux(TreeItem<TreeNode> rootItem) {

        if (rootItem.getChildren().size() > 0) {

            for (TreeItem<TreeNode> child : rootItem.getChildren()) {

                verify(child);

            }
        } else {
            if (rootItem.getValue().getTreeNodeType() != TreeNodeType.Leaf) {

                listVerify.add(false);
            } else {

                listVerify.add(true);
            }
        }

    }

    private boolean verify(TreeItem<TreeNode> rootItem) {

        listVerify = new ArrayList<>();

        verifyAux(rootItem);

        boolean finalLeaf = true;

        for (boolean hasLeaft : listVerify) {

            if (hasLeaft == false) {

                finalLeaf = false;
            }
        }

        return finalLeaf;
    }

    @FXML
    private void addRoot(ActionEvent event
    ) {

        Root root = new Root(questionRoot.getText(), Root);
        rootNodeTree = root;
        this.rootNode = new TreeItem<>(rootNodeTree);

        treeView.setRoot(rootNode);
        haveRoot = true;
        uiControl();
    }

    @FXML
    private void addDecision(ActionEvent event
    ) {

        if ((selectNode != null) && (selectNode.getValue().getTreeNodeType() != TreeNodeType.Leaf)) {

            Desission decision = new Desission(questionDecision.getText(), answerDecision.getText(), Desission);

            selectNode.getChildren().add(new TreeItem<>(decision));
            selectNode.setExpanded(true);
        }

    }

    @FXML
    private void addLeaft(ActionEvent event
    ) {

        if ((selectNode != null) && (selectNode.getValue().getTreeNodeType() != TreeNodeType.Leaf)) {            

            Leaf leaf = new Leaf(answerLeaft.getText(), yesAnswerTree.isSelected(), TreeNodeType.Leaf);

            selectNode.getChildren().add(new TreeItem<>(leaf));
            selectNode.setExpanded(true);
        }
    }
}
