/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decision;

import decision.ui.Login;
import java.io.IOException;
import javafx.application.Application;
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
    private Login login;
    
    //System
    private UserControl userControl;
    

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        initUI();
        initSystem();

        primaryStage.setScene(scene);
        primaryStage.show();
        
        login.start(this);
    }
    
    private void initUI(){
    
        root = new BorderPane();
        login = new Login();
        root.setCenter(login);
        scene = new Scene(root, 720, 480);
        scene.getStylesheets().add("/decision/means/bootstrap3.css");
        scene.getStylesheets().add("/decision/means/DecisionStyles.css");
    }
    
    private void initSystem(){
    
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public UserControl getUserControl() {
        return userControl;
    }

    public void setUserControl(UserControl userControl) {
        this.userControl = userControl;
    }

}
