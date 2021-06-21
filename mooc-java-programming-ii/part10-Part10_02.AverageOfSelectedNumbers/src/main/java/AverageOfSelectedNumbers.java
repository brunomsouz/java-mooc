import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String row = scanner.nextLine();
            
            if (row.equals("end")) {
                break;
            }
            
            inputs.add(row);
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String option = scanner.nextLine();
        
        if (option.equals("p")) {
            System.out.println(positiveAverage(inputs));
        } else {
            System.out.println(negativeAverage(inputs));
        }
        
    }
    
    public static double positiveAverage(List<String> list) {
        double average = list.stream()
                .mapToInt(value -> Integer.parseInt(value))
                .filter(value -> value > 0)
                .average()
                .getAsDouble();
        
        return average;
    }
    
    public static double negativeAverage(List<String> list) {
        double average = list.stream()
                .mapToInt(value -> Integer.parseInt(value))
                .filter(value -> value < 0)
                .average()
                .getAsDouble();
        
        return average;
    }
}
