/**
 * MainController class contains methods and logic to start Word Analyzer JavaFX application
 * @author Nenad Jovanovic
 * @version 1.0
 */
package com.example.word_analyzer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.*;

/**
 * MainController class contains methods and logic to start Word Analyzer JavaFX application
 */
public class MainController implements Initializable {
    /**
     *  file address on the local computer
     */
    public String fileName = "C:\\output.txt";

    @FXML
    TextField URL;
    @FXML
    Label input;
    @FXML
    Button genReport;
    @FXML
    TableView <Word> words;
    @FXML
    TableColumn <Word,Integer> one;
    @FXML
    TableColumn <Word,String> two;
    @FXML
    TableColumn <Word,Integer> three;

    /**
     * Method that reads a file from the local PC, sorts in a map-like structure (key-value pairs) and prints words to the table in the JavaFX application
     * @return LinkedHashMap with top 20 words sorted by frequency
     */
    public LinkedHashMap <String,Integer> sortedWords(){

        LinkedHashMap<String,Integer> sortedMap= new LinkedHashMap<>();
        try {

            //iterate over file and place each word in ArrayList
            ArrayList<String> result = new ArrayList<>();
            Scanner scan = new Scanner(new FileReader(fileName)) ;
            while (scan.hasNext()) {
                result.add(scan.next());
            }

            // iterate over ArrayList and place words in HashMap
            HashMap<String,Integer> wordMap = new HashMap<>();
            for(String word : result) {
                if(wordMap.containsKey(word)) {
                    wordMap.put(word,wordMap.get(word)+1); // if key(word) already in Map increase its value by 1
                }
                else {
                    wordMap.put(word, 1);
                }
            }

            // Sorting HashMap by using comparator and lambda expression to sort by the value
            ArrayList<Map.Entry<String,Integer>> sorted = new ArrayList<>(wordMap.entrySet());
            Collections.sort(sorted,(o1,o2)->{
                        return(o2.getValue()).compareTo(o1.getValue());
                    }
            );

            // Converting HashMap into LinkedHashMap to keep the order of insertion	(HashMap inserts values randomly)

            for(Map.Entry<String,Integer> s : sorted) {
                sortedMap.put(s.getKey(),s.getValue());
            }


            // Placing data from the class Word into Table View by using Observable Lists and CellValueFactory

            ObservableList <Word> data = FXCollections.observableArrayList();
            input.setVisible(false);
            words.setVisible(true);
            Integer count = 1;
            for(Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
                if(count >= 21) {
                    break;
                }
                data.add(new Word(entry.getKey(),entry.getValue(),count));
                count++;
            }

            one.setCellValueFactory(new PropertyValueFactory<Word,Integer>("id"));
            two.setCellValueFactory(new PropertyValueFactory<Word,String>("name"));
            three.setCellValueFactory(new PropertyValueFactory<Word,Integer>("freq"));
            //Adding data to the table
            words.setItems(data);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sortedMap;
    }
    /**
     *JavaFX method that uses the URL address parameter, scrapes the web page by using Jsoup library, and stores the content into a file on the local computer.
     *It also contains a call to the sortedWords() method that reads the scraped file from the local PC, sorts, and prints words to the table in the
     *JavaFX application
     */
    @FXML
    public void scrape() {

        ArrayList<String> scrapedList = new ArrayList<>();
        try {
            String loc = URL.getText();
            //Get Document object after parsing the html from given url.
            Document document = Jsoup.connect(loc).get();
            //Get words from the poem section and store in ArrayList
            Elements words = document.getElementsByClass("chapter");
            Elements wordsD = Objects.requireNonNull(words.first()).getElementsByTag("p");
            for(Element word :wordsD) {
                String x  = word.text().replaceAll("[^A-Za-z0-9-]"," ").replaceAll("\\s+"," ").toLowerCase(); //Using Regex to eliminate non-alphanum chars
                scrapedList.add(x);
            }

            // Output ArrayList with words to a file on the local computer
            FileOutputStream out = new FileOutputStream(fileName);
            PrintStream txt = new PrintStream(out);
            for (int i=0; i < scrapedList.size(); i++) {
                txt.println(scrapedList.get(i));
            }
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        sortedWords();

    }
    /**
     * method that specifies what components of the application will be initialized(or not) during the application startup
     */


    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        URL.setEditable(true);
        URL.requestFocus();
        words.setVisible(false);
        input.setVisible(true);

    }
}