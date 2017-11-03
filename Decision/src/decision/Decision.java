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

/**
 *
 * @author kenma
 */
public class Decision extends Application {

    //UI
    private BorderPane rootLogin;
    private BorderPane rootView;
    private Scene scene;
    Stage myStage;
    BorderPane login;
    BorderPane topBar;

    //Controller
    LoginController loginController;
    TopBarController topBarController;

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
        myStage.setMinHeight(480);
        myStage.setMinWidth(720);
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

}
