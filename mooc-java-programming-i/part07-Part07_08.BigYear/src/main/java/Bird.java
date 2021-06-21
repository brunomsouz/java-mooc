/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Bird {
    private String name;
    private String latinName;
    private int observations;

    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.observations = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLatinName() {
        return this.latinName;
    }
    
    public int getObservations() {
        return this.observations;
    }
    
    public void increaseObservations() {
        this.observations++;
    }
    
    public void increaseObservations(int number) {
        this.observations += number;
    }
    
    public String toString() {
        String toReturn = this.name + "(" + this.latinName + "): " + this.observations;
        
        if (this.observations == 1) {
            return toReturn + " observation";
        }
        
        return toReturn + " observations";
    }
}
