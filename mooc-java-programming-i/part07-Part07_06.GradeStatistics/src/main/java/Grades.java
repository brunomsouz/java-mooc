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

public class Grades {

    private ArrayList<Integer> grades = new ArrayList<>();
    private double averageOfGrades = 0;

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grades.add(grade);
        }
    }

    public double getAverage() {
        if (this.grades.size() > 0) {
            int sum = 0;

            for (int grade : grades) {
                sum += grade;
            }

            return (double) sum / grades.size();
        }

        return -1;
    }
    
    public double getPassingAverage() {        
        if (this.grades.size() > 0) {
            int counter = 0;
            int sum = 0;
            
            for (int grade: grades) {
                if (grade >= 50) {
                    sum += grade;
                    counter++;
                }
            }
            
            return (double) sum / counter;
        }
        
        return -1;
    }
    
    public double getPassPercentage() {
        int counter = 0;
        
        for (int grade: grades) {
            if (grade >= 50) {
                counter++;
            }
        }
        
        return (double) counter / this.grades.size() * 100;
    }
    
    public int pointsToGrades(int maxGrade) {
        int counter = 0;
        
        for (int grade: this.grades) {
            if (maxGrade == this.gradeConverter(grade)) {
                counter++;
            }
        }
        
        return counter;
    }

    public int gradeConverter(int score) {
        if (score < 50) {
            return 0;
        } else if (score < 60) {
            return 1;
        } else if (score < 70) {
            return 2;
        } else if (score < 80) {
            return 3;
        } else if (score < 90) {
            return 4;
        } else {
            return 5;
        }
    }
}
