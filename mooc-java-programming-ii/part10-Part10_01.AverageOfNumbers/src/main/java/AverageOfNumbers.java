
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

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
        
        System.out.println("Average of the numbers: " + average(inputs));
    }
    
    public static double average(List<String> list) {
        double average = list.stream()
                .mapToInt(value -> Integer.valueOf(value))
                .average()
                .getAsDouble();
        
        return average;
    }
}
