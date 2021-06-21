/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.Scanner;

public class TextUI {
    private SimpleDictionary book;
    private Scanner scanner;

    public TextUI(Scanner scanner, SimpleDictionary book) {
        this.book = book;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String input = scanner.nextLine();
            
            if ("end".equals(input)) {
                break;
            }
            
            if ("add".equals(input)) {                
                System.out.print("Word: ");
                String word = scanner.nextLine();
                
                System.out.print("Translation: ");
                String translation = scanner.nextLine();
                
                book.add(word, translation);
                
                continue;
            }
            
            if ("search".equals(input)) {
                System.out.print("To be translated: ");
                String word = scanner.nextLine();
                
                String translation = book.translate(word);
                
                if (translation == null) {
                    System.out.println("Word " + word + " was not found");
                } else {
                    System.out.println("Translation: " + translation);
                }
                
                continue;
            }
            
            System.out.println("Unknown command");
        }
        
        System.out.println("Bye bye!");
    }

}
