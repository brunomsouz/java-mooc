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
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate, String> registry;
    
    public VehicleRegistry() {
        registry = new HashMap<>();
    }
    
    public boolean add(LicensePlate license, String owner) {
        if (!(registry.containsKey(license))) {
            registry.put(license, owner);
            return true;
        }
        
        return false;
    }
    
    public String get(LicensePlate license) {
        return registry.get(license);
    }
    
    public boolean remove(LicensePlate license) {
        if (registry.containsKey(license)) {
            registry.remove(license);
            return true;
        }
        
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate license : registry.keySet()) {
            System.out.println(license);
        }
    }
    
    public void printOwners() {
        ArrayList<String> printed = new ArrayList<>();
        
        for (String owner : registry.values()) {
            if (!(printed.contains(owner))) {
                System.out.println(owner);
                printed.add(owner);
            }
        }
    }
}
