
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        List<String> test = new List<>();
        
        test.add("First");
        test.add("Second");
        test.add("Third");
        test.add("Fourth");
        test.add("Fifth");
        test.add("Sixth");
        test.add("Seventh");
        test.add("Eighth");
        test.add("Ninth");
        test.add("Tenth");
        test.add("Eleventh");
        
        System.out.println(test.value(0));
        System.out.println(test.value(10));
        
        System.out.println(test.indexOf("Eighth"));
        
        System.out.println(test.contains("Eighth"));
        
        System.out.println(test.size());

        test.remove("First");
        
        System.out.println(test.value(0));
        
        System.out.println(test.size());
    }

}
