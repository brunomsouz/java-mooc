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

public class UserInterface {
    private Scanner scanner;
    private JokeManager jokes;

    public UserInterface(JokeManager jokes, Scanner scanner) {
        this.scanner = scanner;
        this.jokes = jokes;
    }
    
    public void start() {
        while (true) {
            System.out.println("Commands:");
            System.out.println("1 - add a joke");
            System.out.println("2 - draw a joke");
            System.out.println("3 - list jokes");
            System.out.println("X - stop");
            String command = scanner.nextLine();
            
            if (command.equals("X")) {
                break;
            }
            
            processCommand(command);
        }
    }
    
    public void processCommand(String command) {
        if (command.equals("1")) {
            add();
        }
        
        if (command.equals("2")) {
            System.out.println(jokes.drawJoke());
        }
        
        if (command.equals("3")) {
            jokes.printJokes();
        }
    }
    
    public void add() {
        System.out.println("Write the joke to be added: ");
        String input = scanner.nextLine();
        
        jokes.addJoke(input);
    }
}
