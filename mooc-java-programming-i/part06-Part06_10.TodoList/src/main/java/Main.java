
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Here you can try out the combined functionality of your classes
        TodoList list = new TodoList();
        
        UserInterface ui = new UserInterface(list, scanner);
        ui.start();

    }
}
