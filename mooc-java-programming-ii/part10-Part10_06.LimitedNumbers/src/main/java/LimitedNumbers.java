import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>();
        
        while (true) {
            int read = Integer.valueOf(scanner.nextLine());
            
            if (read < 0) {
                break;
            }
            
            inputs.add(read);
        }
        
        inputs.stream()
                .filter(value -> value > 0 && value < 6)
                .forEach(value -> System.out.println(value));
    }
}
