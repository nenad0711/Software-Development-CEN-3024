package com.example.final_project_oop;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.*;
import java.io.IOException;

public class FirstBox  {
    public static String userName;
    public void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Trivia");
        Label name = new Label("Enter Your Name :");
        TextField text = new TextField();
        Button btn = new Button("Submit");
        GridPane pane = new GridPane();
        pane.addRow(0,name,text);
        pane.addRow(1,new Label(""),btn);
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(10.0);
        pane.setHgap(10.0);
        Scene scene = new Scene(pane,300,250);
        window.setScene(scene);
        window.showAndWait();
        btn.setOnAction(e-> {
            window.close();
            userName=text.getText();

        });
    }

}