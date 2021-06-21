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
import java.util.List;
import java.util.Iterator;

public class Employees {
    private final List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd) {
        peopleToAdd.forEach(person -> employees.add(person));
    }
    
    public void print() {
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()) {
            Person nextInLine = iterator.next();
            
            if (nextInLine.getEducation() == education) {
                System.out.println(nextInLine);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
