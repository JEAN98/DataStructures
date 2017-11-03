/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import decision.controllers.LoginController;
import decision.controllers.TopBarController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author kenma
 */
public class Decision extends Application {

    //UI
    private BorderPane rootLogin;
    private BorderPane rootView;
    private Scene scene;
    private Stage myStage;
    private BorderPane login;
    private BorderPane topBar;

    //Controller
    private LoginController loginController;
    private TopBarController topBarController;

    //System
    private UserControl userControl;

    @Override
    public void start(Stage primaryStage) throws IOException {

        rootLogin = new BorderPane();
        rootView = new BorderPane();

        initSystem();
        initUI();
        showLogin();

        scene = new Scene(rootLogin, 720, 480);
        scene.getStylesheets().add("/decision/means/bootstrap3.css");
        scene.getStylesheets().add("/decision/means/DecisionStyles.css");

        myStage = primaryStage;
        myStage.setResizable(false);
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

        //Build top bar
        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(Decision.class.getResource("/decision/means/TopBar.fxml"));
        this.topBar = (BorderPane) loader2.load();

        topBarController = loader2.getController();
        topBarController.start(this);

    }

    private void initSystem() {

        userControl = new UserControl();
    }

    public void showLogin() {
        rootLogin.setCenter(this.login);
    }

    public void showView() {
        
        rootView.setTop(this.topBar);
        scene.setRoot(rootView);
        
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

    public BorderPane getTopBar() {
        return topBar;
    }

    public void setTopBar(BorderPane topBar) {
        this.topBar = topBar;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public TopBarController getTopBarController() {
        return topBarController;
    }

    public void setTopBarController(TopBarController topBarController) {
        this.topBarController = topBarController;
    }

    public BorderPane getRootLogin() {
        return rootLogin;
    }

    public void setRootLogin(BorderPane rootLogin) {
        this.rootLogin = rootLogin;
    }

    public BorderPane getRootView() {
        return rootView;
    }

    public void setRootView(BorderPane rootView) {
        this.rootView = rootView;
    }

}
