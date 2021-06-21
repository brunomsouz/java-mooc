/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

/**
 *
 * @author bruno
 */
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SaveableDictionary {
    private final Map<String, String> dictionary;
    private final String file;

    public SaveableDictionary() {
        this(null);
    }

    public SaveableDictionary(String file) {
        dictionary = new HashMap<>();
        this.file = file;
    }
    
    public boolean load() {
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(":");
                
                this.add(parts[0], parts[1]);
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }       
    }
    
    
    public boolean save() {
        List<String> usedWords = new ArrayList<>();
        
        try {
            PrintWriter writer = new PrintWriter(file);
            
            for (String key : dictionary.keySet()) {
                String translation = dictionary.get(key);
                
                if (!usedWords.contains(key)) {
                    writer.write(key + ":" + translation + "\n");
                }
                
                usedWords.add(key);
                usedWords.add(translation);
            }
            
            writer.close();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, translation);
        dictionary.putIfAbsent(translation, word);
    }
    
    public String translate(String word) {
        return dictionary.get(word);
    }
    
    public void delete(String word) {
        dictionary.remove(word);
        
        dictionary.values().remove(word);
    }
}
