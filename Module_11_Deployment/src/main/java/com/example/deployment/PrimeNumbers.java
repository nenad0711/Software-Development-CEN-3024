package com.example.deployment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Main Application class that starts JavaFX application
 * @author Nenad Jovanovic
 * @version 1.0
 */
public class PrimeNumbers extends Application {
    @Override
    /**
     * methods that starts the Scene and shows the content
     */
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrimeNumbers.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Prime Numbers");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * main method that starts the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }


}