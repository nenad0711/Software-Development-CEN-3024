package com.example.deployment;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * MainController - Client class contains methods and logic for PrimeNumbers JavaFX application
 * @author Nenad Jovanovic
 * @version 1.0
 */
public class HelloController implements Initializable {
    @FXML
    private TextField numberTextField;
    @FXML
    private TextArea answer;

    /**
     * client side method that confirms the prime numbers and displays the text
     * @param number
     */
    public void checkPrime(int number) {
        try {
            Socket socket = new Socket("localhost", 8000);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeInt(number);
            out.flush();
            boolean isPrime = in.readBoolean();
            answer.appendText("Number is: "+ number + "\n");
            answer.appendText(number +  " is " + (isPrime ? "prime number." +"\n" : "not prime number." +"\n"));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * fxml method for starting the application on click
     */
    @FXML
    private void onCheckButtonClicked() {
        int number = Integer.parseInt(numberTextField.getText());
        answer.setVisible(true);
        checkPrime(number);
    }

    /**
     * method that initialize JavaFX application
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        answer.setVisible(false);
    }
}
