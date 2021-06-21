/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    private Grades listOfGrades;
    private Scanner scanner;

    public UserInterface(Grades listOfGrades, Scanner scanner) {
        this.listOfGrades = listOfGrades;
        this.scanner = scanner;
    }
    
    
    
    public void start() {
        System.out.println("Enter total points, -1 stops:");
        
        while (true) {            
            int grade = Integer.valueOf(scanner.nextLine());
            
            if (grade == -1) {
                break;
            }
            
            this.listOfGrades.addGrade(grade);
        }
        
        this.printAverage();
    }
    
    public void printAverage() {
        System.out.println("Point average (all): " + this.listOfGrades.getAverage());
        
        if (this.listOfGrades.getPassingAverage() > 0) {
            System.out.println("Point average (passing): " + this.listOfGrades.getPassingAverage());
        } else {
            System.out.println("Point average (passing): -");
        }
        
        System.out.println("Pass percentage: " + this.listOfGrades.getPassPercentage());
        
        System.out.println("Grade distribution: ");
        int maxGrade = 5;
        while (maxGrade >= 0) {
            System.out.print(maxGrade + ": ");
            printStars(this.listOfGrades.pointsToGrades(maxGrade));
            System.out.println("");
            maxGrade--;
        }
    }
    
    public void printStars(int numberOfStars) {
        while (numberOfStars > 0) {
            System.out.print("*");
            numberOfStars--;
        }
    }
}
