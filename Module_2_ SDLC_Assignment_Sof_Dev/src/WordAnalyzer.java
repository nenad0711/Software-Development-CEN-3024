/**
 * Project Name: Word Analyzer program
 * Description: text analyzer that reads a file and outputs statistics about that file. It should output the word frequencies of all words in the file, 
    sorted by the most frequently used word. The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.
 * written by: @author Nenad Jovanovic (njovanovic1@mail.valenciacollege.edu)
 * created: 2/2/23
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class WordAnalyzer {
	
       
	/** Scrape method takes the URL address parameter, scrapes the web by using Jsoup Library, and stores the content into a file on the local computer.
        It also contains a call to the sortedWords() method that reads the scraped file from the local pc, sorts, and prints words to the console */
	
    public static void scrape(String location) {
    	
            ArrayList<String> scrapedList = new ArrayList<>();
		try {
			
			//Get Document object after parsing the html from given url.
			Document document = Jsoup.connect(location).get();
			Elements title = document.select("h1"); //Get title
			Elements writer = document.select(".no-break"); //Get writer
			System.out.println(title.text()); 
			System.out.println(writer.text()+"\n");
			
			//Get words from the poem section and store in ArrayList
			Elements words = document.getElementsByClass("chapter"); 
			Elements wordsD = words.first().getElementsByTag("p");
			for(Element word :wordsD) {
				String x  = word.text().replaceAll("[^A-Za-z0-9-]"," ").replaceAll("\\s+"," ").toLowerCase(); //Using Regex to eliminate non-alphanum chars
				scrapedList.add(x);
			}
			
		   // Output ArrayList with words to a file on the local computer
			FileOutputStream out = new FileOutputStream("C:\\output.txt");  
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
       
       
       
 // Method that takes file address parameter, and returns the word frequencies of all words in the file in the Map structure (key-value pairs)      
       
	public static void sortedWords(){
	  try {
			
        //iterate over file and place each word in ArrayList
		ArrayList<String> result = new ArrayList<>();
		Scanner scan = new Scanner(new FileReader("C:\\output.txt")) ;
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
	    HashMap<String,Integer> sortedMap = new LinkedHashMap<>();
	    for(Map.Entry<String,Integer> s : sorted) {
	    	sortedMap.put(s.getKey(),s.getValue());
	    	
	    }
	    
	    // Printing to the console
	    for(String i : sortedMap.keySet()) {
			 System.out.println(i + "  " + sortedMap.get(i) );
			}	
		}
	  
		catch (FileNotFoundException e) {
			e.printStackTrace();
	  }
	}
   }