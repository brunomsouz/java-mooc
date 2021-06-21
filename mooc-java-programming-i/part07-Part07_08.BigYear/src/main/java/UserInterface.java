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
import java.util.ArrayList;

public class UserInterface {

    private ArrayList<Bird> birds;
    private Scanner scanner;

    public UserInterface(ArrayList<Bird> birds, Scanner scanner) {
        this.birds = birds;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("? ");
            String input = scanner.nextLine();

            if (input.equals("Quit")) {
                break;
            }

            processCommand(input);
        }
    }

    public void processCommand(String command) {
        if (command.equals("Add")) {
            addBird();
        }

        if (command.equals("All")) {
            printAllBirds();
        }

        if (command.equals("Observation")) {
            addObservation();
        }

        if (command.equals("One")) {
            printOneBird();
        }
    }

    public void addBird() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Name in latin: ");
        String latinName = scanner.nextLine();

        birds.add(new Bird(name, latinName));
    }

    public void printAllBirds() {
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }

    public void addObservation() {
        System.out.print("Bird? ");
        String birdToIncrease = scanner.nextLine();
        boolean found = false;

        for (Bird bird : birds) {
            if (bird.getName().equals(birdToIncrease)) {
                bird.increaseObservations();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not a bird!");
        }
    }

    public void printOneBird() {
        System.out.print("Bird? ");
        String birdToPrint = scanner.nextLine();
        boolean found = false;

        for (Bird bird : birds) {
            if (bird.getName().equals(birdToPrint)) {
                System.out.println(bird);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not a bird!");
        }
    }
}
