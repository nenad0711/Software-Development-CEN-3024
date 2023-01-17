package com.example.final_project_oop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController{



    @FXML
    Label nameArea;




    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }



}