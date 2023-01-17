import java.util.ArrayList;
import java.util.List;

public class TestingGenerics {
    public static void main(String[] args) {
        /* PART I */
        List<String> strArray = new ArrayList<>() {{ add("Orlando");add("Miami");add("Tampa");}};
        List<Integer> intArray = new ArrayList<>() {{add(15);add(25);add(35);}};
        List<Character> chaArray = new ArrayList<>() {{add('k');add('l');add('m');}};

                        /* Print the index number of the given element **/
        System.out.println( "------PART I------");
        System.out.println("Index of the given element in the String array is: " + returnIndex(strArray,"Miami"));
        System.out.println("Index of the given element in the Integer array is: " + returnIndex(intArray,15));
        System.out.println("Index of the given element in the Character array is: " + returnIndex(chaArray,'m'));
    /* PART II */
        System.out.println( "------PART II------");
        Gold gold = new Gold();
        Silver silver = new Silver();
        System.out.println("What has greater value? : " + greaterThan(gold,silver));


    }

    public static<T extends Comparable<T>>int returnIndex( List<T> array, T elem) {
        int index = 0;
        for (T element : array) {
            if (element.compareTo(elem) == 0) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static<T extends Valuable> T greaterThan (T object1,T object2){
        if(object1.returnValue()>object2.returnValue()){
            return object1;
        }
        return object2;
    }
}

