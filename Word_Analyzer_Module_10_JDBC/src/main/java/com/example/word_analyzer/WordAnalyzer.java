/**
 * This class contains main method to run JavaFX application WordAnalyzer via MainController
 * @author Nenad Jovanovic
 * @version 1.0
 */
package com.example.word_analyzer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * WordAnalyzer class contains main method to run JavaFX application WordAnalyzer via MainController
 */
public class WordAnalyzer extends Application {
    /**
     * method start from the Application class that launches the JavaFX application via word_analyzer.fxml file
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WordAnalyzer.class.getResource("word_analyzer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 816, 688);
        stage.setTitle("Word Analyzer");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * This is the main method.
     * @param args Strings passed into the main
     */
    public static void main(String[] args) {
        launch();
    }
}