package org.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.demo3.Utils.DataBaseConnection;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        try {
            DataBaseConnection db = DataBaseConnection.getInstance();
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Gestion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }






}
