
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDictionary book = new SimpleDictionary();
        TextUI userInterface = new TextUI(scanner, book);
        
        userInterface.start();
    }
}
