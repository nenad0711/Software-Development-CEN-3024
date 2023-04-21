package com.example.deployment;
import java.io.*;
import java.net.*;
/**
 *This class contains main method to run Server application when upon request prime number validation is provided
 *  @author Nenad Jovanovic
 *  @version 1.0
 */
public class PrimeServer {
    /**
     * This the main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");
        // open a socket and listen for requests
        while (true) {
            Socket socket = serverSocket.accept();

            Thread thread = new Thread(() -> {
                try {
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    // read the input and check whether the number is a prime
                    int number = in.readInt();
                    System.out.println("Number received: " + number);
                    boolean isPrime = isPrime(number);

                    out.writeBoolean(isPrime);
                    out.flush();

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            );

            thread.start();
        }
    }

    /**
     * method that checks whether the provided number is a prime number
     * @param number to be checked
     * @return
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}



