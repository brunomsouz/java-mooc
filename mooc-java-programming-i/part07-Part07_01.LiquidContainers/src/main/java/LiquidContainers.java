
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int firstContainer = 0;
        int secondContainer = 0;

        while (true) {
            System.out.println("First: " + firstContainer + "/100");           
            System.out.println("Second: " + secondContainer + "/100");
            
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int value = Integer.valueOf(parts[1]);
            
            if (value < 0) {
                continue;
            }
            
            if (command.equals("add")) {
                firstContainer += value;
                
                if (firstContainer >= 100) {
                    firstContainer = 100;
                }
            }
            
            if (command.equals("move")) {
                if (firstContainer - value < 0) {
                    value = firstContainer;
                    firstContainer = 0;
                } else {
                    firstContainer -= value;
                }
                
                secondContainer += value;
                
                if (secondContainer >= 100) {
                    secondContainer = 100;
                }
            }
             
            if (command.equals("remove")) {
                secondContainer -= value;
                
                if (secondContainer < 0) {
                    secondContainer = 0;
                }
            }
        }
    }

}
