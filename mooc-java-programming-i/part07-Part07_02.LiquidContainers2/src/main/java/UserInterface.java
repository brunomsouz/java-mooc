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
    private Container firstContainer;
    private Container secondContainer;
    private Scanner scanner;

    public UserInterface(Container firstContainer, Container secondContainer, Scanner scanner) {
        this.firstContainer = firstContainer;
        this.secondContainer = secondContainer;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.println("First: " + firstContainer.toString());
            System.out.println("Second: " + secondContainer.toString());
            String input = scanner.nextLine();
            
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int value = Integer.valueOf(parts[1]);
            
            processCommand(command, value);
        }
    }
    
    public void processCommand(String command, int value) {
        if (command.equals("add")) {
            add(value);
        }
        
        if (command.equals("move")) {
            move(value);
        }
        
        if (command.equals("remove")) {
            remove(value);
        }
    }
    
    public void add(int amount) {
        this.firstContainer.add(amount);
    }
    
    public void move(int amount) {
        if (this.firstContainer.contains() < amount) {
            amount = this.firstContainer.contains();
        }
        
        this.firstContainer.remove(amount);
        this.secondContainer.add(amount);
    }
    
    public void remove(int amount) {
        this.secondContainer.remove(amount);
    }
}
