package com.example.final_project_oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {



    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 816, 688);
        primaryStage.setTitle("Trivia Game");
        primaryStage.setScene(scene);
        FirstBox fb = new FirstBox();
        primaryStage.show();
        fb.display();
    }

    public static void main(String[] args) {

        launch();
    }
}