import java.util.Scanner;

/**
 * Project Name: Word Analyzer program
 * Description: text analyzer that reads a file and outputs statistics about that file. It should output the word frequencies of all words in the file, 
    sorted by the most frequently used word. The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.
 * written by: @author Nenad Jovanovic (njovanovic1@mail.valenciacollege.edu)
 * created: 2/2/23
 */


public class WordAnalyzerTest {

	public static void main(String[] args) {
		String fileAddress;
		//String localFileAddress;
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter file address: ");
		fileAddress = scan.next();
		scan.close();
	    // Get the content from the URL by using static method scrape from the WordAnalyzer class
		WordAnalyzer.scrape(fileAddress);
	    

	
}
}

