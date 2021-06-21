/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.HashMap;

public class Abbreviations {
    HashMap<String, String> abbreviations;

    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviation = sanitizedString(abbreviation);
        explanation = sanitizedString(explanation);
        
        if (!hasAbbreviation(abbreviation)) {
            this.abbreviations.put(abbreviation, explanation);
        } else {
            System.out.println("Abbreviation already added.");
        }
    }
    
    public boolean hasAbbreviation(String abbreviation) {
        return this.abbreviations.containsKey(abbreviation);
    }
    
    public String findExplanationFor(String abbreviation) {
        return this.abbreviations.get(abbreviation);
    }
    
    public static String sanitizedString(String string) {
        if (string == null) {
            return "";
        }
        
        string = string.toLowerCase();
        return string.trim();
    }
}
