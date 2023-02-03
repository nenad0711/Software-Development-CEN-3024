public class Generics{
    public static void main(String[] args) {
    String [] strArray = new String[]{"Orlando","Miami","Tampa","Atlanta"};
    Integer [] intArray = new Integer[]{10,99,109,15};
    Character [] chaArray = new Character[]{'k','j','l','m'};
    System.out.println("Index of the given element in the String array is: " + returnIndex(strArray,"Miami"));
    System.out.println("Index of the given element in the Integer array is: " + returnIndex(intArray,10));
    System.out.println("Index of the given element in the Character array is: " + returnIndex(chaArray,'l'));
    }
/** method returnIndex only sorts Objects that extend Comparable interface **/

    public static <T extends Comparable<T>> int returnIndex(T[] array, T elem) {
        int index = 0;
        for (T element : array) {

            if (element.compareTo(elem) == 0) {
                return index;
            }
            index++;
        }
        return -1;

    }

        }













