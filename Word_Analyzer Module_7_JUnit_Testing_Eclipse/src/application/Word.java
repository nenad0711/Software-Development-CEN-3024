/**
 * This class contains Word elements and its attributes from the text file given for analysis via TextAnalyzer   
 * @author Nenad Jovanovic 
 * @version 1.0
 */


package application;

public class Word {
	String name;
	Integer freq;
	Integer id;
	   /**
	    * Constructor that takes three parameters
	    * @param name represents the name for the word
	    * @param freq represents the number of times that word appears in the given text
	    * @param id   position of the word on the list (1st,2nd etc..)
	    */
	  public Word(String name, Integer freq,Integer id){
	        this.name = name;
	        this.freq = freq;
	        this.id = id;
	    }
/**
 * @return name of the word
 */
	    public String getName() {
	        return name;
	    }
/**
 * @param name represents the name for the word
 */
	    public void setName(String name) {
	        this.name = name;
	    }
/**
 * @return the number of times that word appears in the given text
 */
	    public Integer getFreq() {
	        return freq;
	    }
/**
 * @param point represents the number of times that word appears in the given text
 */
	    public void setFreq(int point) {
	        this.freq = point;
	    }
/** 
 * @return position of the word on the list (1st,2nd etc..)
 */ 
	    public Integer getId() {
	        return id;
	    }
/**
 * @param id - position of the word on the list (1st,2nd etc..)
 */
	    public void setId(int id) {
	        this.id = id;
	    }
	}
	

