/**
 * Computation class contains methods to calculate the sum of array in a sequence and in parallel
 * @author Nenad Jovanovic
 * @version 1.0
 */


public class Computation {
    public int [] arr;
    final int start = 0;
    int end;
    int middle;

    /**
     * Constructor for Computation class
     * @param a represents array which elements are summed
     * @param array_length number of elements in a given array
     */
    public Computation(int[] a,int array_length){
        arr = a;
        end = array_length;
        middle = array_length / 2;
    }

    /**
     *
     * @return total sum of instance variable arr
     */
    public int singleThread(){
        int totalCount = 0;
        for (int i : arr) {
            totalCount += i;
        }
        return totalCount;
    }

    /**
     *
     * @return total sum of the first 1/2 of elements in instance variable arr
     */
    public int firstT(){
        int totalCount1 =0;
        for(int x = start; x < middle;x++){
            totalCount1 += arr[x];
        }
        return totalCount1;
    }
    /**
     *
     * @return total sum of the first 1/2 of elements in instance variable arr
     */
    public int secondT(){
        int totalCount2 =0;
        for(int x = middle; x < end;x++){
            totalCount2 += arr[x];
        }
        return totalCount2;
    }
}
