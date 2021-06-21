import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        
        while (true) {
            String read = scanner.nextLine();
            
            if (read.isEmpty()) {
                break;
            }
            
            inputs.add(read);
        }
        
        inputs.stream().forEach(value -> System.out.println(value));
    }
}
