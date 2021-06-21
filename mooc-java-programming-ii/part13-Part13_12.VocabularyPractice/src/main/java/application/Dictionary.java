/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author bruno
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Dictionary {
    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        words = new ArrayList<>();
        translations = new HashMap<>();
        
        add("one", "um");
    }
    
    public void add(String word, String translation) {
        if (!translations.containsKey(word)) {
            words.add(word);
        }
        
        translations.put(word, translation);
    }
    
    public String get(String word) {
        return translations.get(word);
    }
    
    public String getRandomWord() {
        Random random = new Random();
        
        return words.get(random.nextInt(words.size()));
    }
}
