package title;

import javafx.application.Application;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String title = askTitle();
        
        Application.launch(UserTitle.class,
                "--title=" + title);
    }
    
    public static String askTitle() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Give a title: ");
        String title = scanner.nextLine();
        
        return title;
    }
}
