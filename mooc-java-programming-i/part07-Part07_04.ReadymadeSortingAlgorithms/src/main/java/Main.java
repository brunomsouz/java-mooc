import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // insert test code here
        int[] intArray = {3, 1, 5, 99, 3, 12};
        sort(intArray);
        System.out.println(Arrays.toString(intArray));
        
        String[] stringArray = {"Bruno", "Billy", "Evelin", "Magali"};
        sort(stringArray);
        System.out.println(Arrays.toString(stringArray));
        
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(8);
        numbers.add(3);
        numbers.add(5);
        Collections.sort(numbers);
        System.out.println(numbers);
        
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Bruno");
        strings.add("Thor");
        strings.add("Agatha");
        strings.add("Bacon");
        Collections.sort(strings);
        System.out.println(strings);
    }
    
    public static void sort(int[] array) {
        Arrays.sort(array);
    }
    
    public static void sort(String[] array) {
        Arrays.sort(array);
    }
    
    public static void sortIntegers(ArrayList<Integer> integers) {
        Collections.sort(integers);
    }
    
    public static void sortStrings(ArrayList<String> strings) {
        Collections.sort(strings);
    }

}
