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
    private TodoList tasks;
    private Scanner scanner;

    public UserInterface(TodoList tasks, Scanner scanner) {
        this.tasks = tasks;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String input = scanner.nextLine();
            
            if (input.equals("stop")) {
                break;
            }
            
            processCommand(input);
        }
    }
    
    public void processCommand(String command) {
        if (command.equals("add")) {
            System.out.print("To add: ");
            String task = scanner.nextLine();
            
            tasks.add(task);
        }
        
        if (command.equals("list")) {
            tasks.print();
        }
        
        if (command.equals("remove")) {
            System.out.print("Which one is removed? ");
            int task = Integer.valueOf(scanner.nextLine());
            
            tasks.remove(task);
        }
    }
}
