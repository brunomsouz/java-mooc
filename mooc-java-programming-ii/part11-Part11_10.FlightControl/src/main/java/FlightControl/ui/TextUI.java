/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

/**
 *
 * @author bruno
 */
import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.domain.Airplane;

public class TextUI {

    private final FlightControl control;
    private final Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.control = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.print("> ");
            String option = scanner.nextLine();
            
            switch (option) {
                case "x":
                    break OUTER;
                case "1":
                    addAirplane();
                    break;
                case "2":
                    addFlight();
                    break;
                default:
                    break;
            }
        }
    }

    private void addAirplane() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        control.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println("Give the departure airport id: ");
        String origin = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String destination = scanner.nextLine();

        control.addFlight(id, origin, destination);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String option = scanner.nextLine();
            
            switch (option) {
                case "x":
                    break OUTER;
                case "1":
                    printAirplanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printAirplane();
                    break;
                default:
                    break;
            }
        }
    }

    private void printAirplanes() {
        control.getAirplanes().forEach(plane -> System.out.println(plane));
    }

    private void printFlights() {
        control.getFlights().forEach(flight -> System.out.println(flight));
    }

    private void printAirplane() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();

        Airplane plane = control.getAirplane(id);

        if (plane == null) {
            System.out.println("No airplane with the id " + id + ".");
        } else {
            System.out.println(plane);
        }
    }
}
