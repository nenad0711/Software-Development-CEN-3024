/**
 * DBConn class contains methods and logic to store and retrieve data from MySql database
 * @author Nenad Jovanovic
 * @version 1.0
 */
package com.example.word_analyzer;
import org.jsoup.nodes.Element;
import java.sql.*;
import java.util.ArrayList;

/**
 * DBConn class contains methods and logic to store and retrieve data from MySql database
 */
public class DBConn {
    String jdbc = "jdbc:mysql://127.0.0.1:3306/word occurrences";
    String username = "java_user";
    String pass = "java123";
    String query = "INSERT INTO words (word_name) VALUES(?) ";
   //adding additional elements to MySql Database
    String[] elem ={"Barcelona","Miami","Belgrade","Moscow"};

    /**
     * Method that stores scraped web data into MySql Database
     * @param arr is an ArrayList of JSoup Elements that need to be stored in MySql database
     * @throws SQLException
     */
    public void insert_into_DB(ArrayList<Element> arr) throws SQLException {
        Connection conn = DriverManager.getConnection(jdbc,username,pass);
        PreparedStatement ps = conn.prepareStatement(query);
        for(String s : elem){
            ps.setString(1,s);
            ps.executeUpdate();
        }
        for (Element word : arr) {
            ps.setString(1,(word.text()));
            ps.executeUpdate();
        }
        ps.close();
        conn.close();
    }
    /**
     * Method that retrieves scraped web data from MySql Database
     * @return retrieves ArrayList of text data from MySql Database
     * @throws SQLException
     */
    public ArrayList<String> get_mysql_data() throws SQLException {
        ArrayList<String> data = new ArrayList<>();
        Connection conn = DriverManager.getConnection(jdbc,username,pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM words");
        while (rs.next()) {
            String rowData = rs.getString("word_name");
            data.add(rowData);
        }
        rs.close();
        stmt.close();
        conn.close();
        return data;
    }
}
