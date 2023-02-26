
/**
 * This class contains two methods for finding Fibonacci number by using iterative and recursive approach, respectively.  
 * @author Nenad Jovanovic 
 * @version 1.0
 */

public class Fibonacci {
	/**
	 * Returns the Fibonacci number by using iterative approach
	 * @param n The number n represents the position of the number that we are searching for in the Fibonacci sequence.
	 * @return Value associated with the nth position in the Fibonacci sequence. 
	 */
		   public static int fib(int n) {
			   int a = 0; 
			   int b = 1;
			   int c;
			    if (n == 0)
		            return a;
		        for (int i = 2; i <= n; i++)
		        {
		            c = a + b;
		            a = b;
		            b = c;
		        }
		        return b;
		    }
		   
	/**
	 * Returns the Fibonacci number by using recursive approach 
	 * @param n The number n represents the position of the number that we are searching for in the Fibonacci sequence.
	 * @return Value associated with the nth position in the Fibonacci sequence. 
	 */
		
		  public static int fibonacciRecursive(int n)
		    {
		        if (n <= 1)
		            return n;
		        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
		    }
		   
		  /**
		   * This is the main method. Recursive and iterative methods for finding Fibonacci number are tested and timed in nano seconds.
		   * @param args Strings passed into the main
		   */
		      
		    public static void main (String args[])
		    {
		        int n = 45;
		        long startTime = System.nanoTime();
		        System.out.println(fib(n));
		        long endTime = System.nanoTime();
		        System.out.println(endTime-startTime);
		        startTime = System.nanoTime();
		        System.out.println(fibonacciRecursive(n));
		        endTime = System.nanoTime();
		        System.out.println(endTime-startTime);
		    }
		}
		
		
		
		
		
		
		
		
		
	

	
	
	
	
	
	
	
	
	


