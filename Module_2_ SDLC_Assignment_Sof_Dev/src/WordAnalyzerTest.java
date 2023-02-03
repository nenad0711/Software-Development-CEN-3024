/**
 * Project Name: Word Analyzer program
 * Description: text analyzer that reads a file and outputs statistics about that file. It should output the word frequencies of all words in the file, 
    sorted by the most frequently used word. The output should be a set of pairs, each pair containing a word and how many times it occurred in the file.
 * written by: @author Nenad Jovanovic (njovanovic1@mail.valenciacollege.edu)
 * created: 2/2/23
 */


public class WordAnalyzerTest {

	public static void main(String[] args) {
		
	    // Get the content from the URL by using static method scrape from the WordAnalyzer class
		WordAnalyzer.scrape("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
	    
		// Instantiate WordAnalyzer class with the file address in the constructor
		
		new WordAnalyzer("C:\\output.txt");
	}
}

