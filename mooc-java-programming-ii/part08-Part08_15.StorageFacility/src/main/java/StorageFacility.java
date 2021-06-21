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
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storageUnit;

    public StorageFacility() {
        storageUnit = new HashMap<>();
    }
    
    public void add(String unit, String item) {
        storageUnit.putIfAbsent(unit, new ArrayList<>());
        
        storageUnit.get(unit).add(item);
    }
    
    public ArrayList<String> contents(String unit) {
        return storageUnit.getOrDefault(unit, new ArrayList<>());
    }
    
    public void remove(String unit, String item) {
        storageUnit.get(unit).remove(item);
        
        if (storageUnit.get(unit).isEmpty()) {
            storageUnit.remove(unit);
        }
    }
    
    public ArrayList<String> storageUnits() {
        ArrayList<String> storageList = new ArrayList<>();
        
        for (String unit : storageUnit.keySet()) {
            storageList.add(unit);
        }
        
        return storageList;
    }
}
