import java.util.Random;
/**
 * Computation_Test computes the sum of an array (instance of Computation class) in parallel using multiple threads,compares performance
 * with only one thread computation, and display the sum and times for both cases.
 * @author Nenad Jovanovic
 * @version 1.0
 */

public class Computation_Test {
    /**
     *
     * @param args This is the Main method
     */
    public static void main(String[] args) {
        Random random  = new Random();
        int num_of_elements = 200000000;
        int [] sumInt = new int[num_of_elements];
        Computation compute = new Computation(sumInt,num_of_elements);

        // add 200 mill of random elements from 1-10 to int array
        for(int i = 0; i<sumInt.length; i++){
            sumInt[i] = random.nextInt(10)+1;
        }
        // calculate the time needed for a single thread to calculate the sum of the given array
        long start = System.nanoTime();
        int total = compute.singleThread();
        System.out.println("Single Thread: " + (System.nanoTime() - start) + "  Result "+ total);
        // Two Runnable tasks for two threads to calculate the sum of the given array in parallel(each will sum 1/2 of elements)
        Runnable run1 = () ->  compute.firstT();
        Runnable run2 = () ->  compute.secondT();
        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);
        start = System.nanoTime();
        th1.start();
        th2.start();
        System.out.print( "Multiple Threads: " + (System.nanoTime() - start));
        int w = compute.firstT() + compute.secondT();
        System.out.println(" Result " +  w);
    }
}
