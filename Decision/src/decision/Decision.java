/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import decision.controllers.LoginController;
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

    //System
    private UserControl userControl;

    @Override
    public void start(Stage primaryStage) throws IOException {

        

        root = new BorderPane();
        initSystem();
        initUILogin();
        
        scene = new Scene(root, 720, 480);
        scene.getStylesheets().add("/decision/means/bootstrap3.css");
        scene.getStylesheets().add("/decision/means/DecisionStyles.css");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initUILogin() throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Decision.class.getResource("/decision/means/Login.fxml"));
        BorderPane start = (BorderPane) loader.load();
        root.setCenter(start);
        
        LoginController loginController = loader.getController();
        loginController.start(this);

    }

    private void initSystem() {

        userControl = new UserControl();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public BorderPane getRoot() {
        return root;
    }

    public void setRoot(BorderPane root) {
        this.root = root;
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
