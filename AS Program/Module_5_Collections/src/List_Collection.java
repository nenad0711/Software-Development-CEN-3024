import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class List_Collection {
    public static void main(String[] args) {
        List<String> my_Array = new ArrayList<> ();
        my_Array.add("Barcelona");
        my_Array.add("Valencia");
        my_Array.add("Madrid");
        my_Array.add("Cadiz");
        my_Array.add("Malaga");
        my_Array.add("Vigo");
        my_Array.add("Alcorcon");
        my_Array.add("Alaves");
        System.out.println("----Unsorted List----");
        for (String s :my_Array){
            System.out.println(s);
        }
        System.out.println("----Sorted List----");
        Collections.sort(my_Array);
        for (String s :my_Array){
            System.out.println(s);
        }
        System.out.println("----Shuffled List----");
        Collections.shuffle(my_Array);
        for (String s :my_Array){
            System.out.println(s);
        }
/** Collections is a class that we use to apply different static methods on the Collection interface type. Interface is used to represent a group of objects as a single unit */

        System.out.println("----Positions----");

        System.out.println("Barcelona is on the index: " + my_Array.indexOf("Barcelona"));
        System.out.println("Paris is on the index: "+ my_Array.indexOf("Paris"));

        String [] new_Array = my_Array.toArray(new String[0]);
        System.out.println(Arrays.toString(new_Array));
        List<String> list = Arrays.asList(new_Array);
        System.out.println(list);
    }

}
