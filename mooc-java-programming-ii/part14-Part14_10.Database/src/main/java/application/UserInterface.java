package application;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private int counter;
    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
        counter = 1;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();            
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here
            
            if (command.equals("1")) {
                list();
            }
            
            if (command.equals("2")) {
                add();
            }
            
            if (command.equals("3")) {
                markAsDone();                        
            }
            
            if (command.equals("4")) {
                remove();
            }
        }       

        System.out.println("Thank you!");
    }
    
    public void add() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        
        System.out.println("Enter description");
        String description = scanner.nextLine();
        
        database.add(new Todo(counter, name, description, false));
        counter++;
    }
    
    public void list() throws SQLException {
        System.out.println("Listing the database contents");
        database.list().forEach(todo -> System.out.println("id=" + todo.getId() +
                ", name=" + todo.getName() +
                ", description=" + todo.getDescription() +
                ", done=" + todo.getDone() +
                "}"));
    }
    
    public void markAsDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());
        
        database.markAsDone(id);
    }
    
    public void remove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.parseInt(scanner.nextLine());
        
        database.remove(id);
    }
}
