package hms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class hmsMain extends Application {

    static final String appName = "Hospital Management System";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hmsLogin.fxml"));
        primaryStage.setResizable(false);
        primaryStage.setTitle(appName);
        primaryStage.setScene(new Scene(root, 491, 317));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
