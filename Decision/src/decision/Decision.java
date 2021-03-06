/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import decision.controllers.EditTreeController;
import decision.controllers.LoginController;
import decision.controllers.TreeViewCenterController;
import decision.controllers.UseController;
import decision.controllers.ViewCatalogController;
import decision.controllers.ViewProphileController;
import decision.controllers.ViewTreeController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author kenma
 */
public class Decision extends Application {

    //UI
    private BorderPane root;
    private Scene scene;
    private Stage myStage;
    private BorderPane login;
    private BorderPane viewProphile;
    private BorderPane viewCatalog;
    private BorderPane viewTree;
    private BorderPane editTree;
    private BorderPane treeViewCenter;
    private BorderPane use;

    //Controller
    private LoginController loginController;
    private ViewProphileController viewProphileController;
    private ViewCatalogController viewCatalogController;
    private ViewTreeController viewTreeController;
    private EditTreeController editTreeController;
    private TreeViewCenterController treeViewCenterController;
    private UseController useController;

    //System
    private UserControl userControl;
    private GeneratorID generatorID;

    //Test
    private Tester tester = new Tester();

    @Override
    public void start(Stage primaryStage) throws IOException {

        root = new BorderPane();

        initSystem();
        initUI();
        showLogin();

        scene = new Scene(root, 720, 480);
        scene.getStylesheets().add("/decision/means/bootstrap3.css");
        scene.getStylesheets().add("/decision/means/DecisionStyles.css");

        //Test
        tester.test(userControl, generatorID);

        myStage = primaryStage;
//        myStage.setMaximized(true);
//        myStage.setResizable(false);
        myStage.setScene(scene);
        myStage.show();

    }

    private void initUI() throws IOException {

        //Build login
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/Login.fxml"));
        this.login = (BorderPane) loader.load();

        loginController = loader.getController();
        loginController.start(this);

        //Build prophile
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(Decision.class.getResource("/decision/means/ViewProphile.fxml"));
        this.viewProphile = (BorderPane) loader2.load();

        viewProphileController = loader2.getController();

        //Build Tree
        FXMLLoader loader3 = new FXMLLoader();
        loader3.setLocation(Decision.class.getResource("/decision/means/ViewTree.fxml"));
        this.viewTree = (BorderPane) loader3.load();

        viewTreeController = loader3.getController();

        //Build catalog
        FXMLLoader loader4 = new FXMLLoader();
        loader4.setLocation(Decision.class.getResource("/decision/means/ViewCatalog.fxml"));
        this.viewCatalog = (BorderPane) loader4.load();

        viewCatalogController = loader4.getController();

        //Build catalog
        FXMLLoader loader5 = new FXMLLoader();
        loader5.setLocation(Decision.class.getResource("/decision/means/EditTree.fxml"));
        this.editTree = (BorderPane) loader5.load();

        editTreeController = loader5.getController();

        //Build catalog
        FXMLLoader loader6 = new FXMLLoader();
        loader6.setLocation(Decision.class.getResource("/decision/means/TreeViewCenter.fxml"));
        this.treeViewCenter = (BorderPane) loader6.load();

        treeViewCenterController = loader6.getController();

        //Build catalog
        FXMLLoader loader7 = new FXMLLoader();
        loader7.setLocation(Decision.class.getResource("/decision/means/Use.fxml"));
        this.use = (BorderPane) loader7.load();

        useController = loader7.getController();
    }

    private void initSystem() {

        userControl = new UserControl();
        generatorID = new GeneratorID();
    }

    public void showLogin() {

        root.setCenter(this.login);

    }

    public void showProphile() {

        root.setCenter(viewProphile);
        viewProphileController.start(this);

    }

    public void showTree() {

        root.setCenter(viewTree);
        viewTreeController.start(this);

    }

    public void showCatalog() {

        root.setCenter(viewCatalog);
        viewCatalogController.start(this);

    }

    public void showEditTree(Tree tree) {

        root.setCenter(editTree);
        editTreeController.start(tree, this);

    }

    public void showTreeViewCenter(Tree tree, boolean isShowtree) {

        root.setCenter(treeViewCenter);
        treeViewCenterController.start(tree, isShowtree, this);

    }

    public void showUse(Tree tree) {

        root.setCenter(use);
        useController.start(tree, this);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public UserControl getUserControl() {
        return userControl;
    }

    public void setUserControl(UserControl userControl) {
        this.userControl = userControl;
    }

    public Stage getMyStage() {
        return myStage;
    }

    public void setMyStage(Stage myStage) {
        this.myStage = myStage;
    }

    public BorderPane getLogin() {
        return login;
    }

    public void setLogin(BorderPane login) {
        this.login = login;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public BorderPane getViewProphile() {
        return viewProphile;
    }

    public void setViewProphile(BorderPane viewProphile) {
        this.viewProphile = viewProphile;
    }

    public ViewProphileController getViewProphileController() {
        return viewProphileController;
    }

    public void setViewProphileController(ViewProphileController viewProphileController) {
        this.viewProphileController = viewProphileController;
    }

    public GeneratorID getGeneratorID() {
        return generatorID;
    }

    public void setGeneratorID(GeneratorID generatorID) {
        this.generatorID = generatorID;
    }

}
