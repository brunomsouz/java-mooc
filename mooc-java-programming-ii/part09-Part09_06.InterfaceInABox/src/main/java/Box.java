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

public class Box implements Packable {
    private final double capacity;
    private final ArrayList<Packable> items;

    public Box(double capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    public void add(Packable item) {
        if (this.weight() + item.weight() <= capacity) {
            this.items.add(item);
        } 
    }
    
    public double getCapacity() {
        return this.capacity;
    }
    
    @Override
    public double weight() {
        double totalWeight = 0;
        
        for (Packable item : items) {
            totalWeight += item.weight();
        }
        
        return totalWeight;
    }
    
    @Override
    public String toString() {
//        if (items.size() == 1) {
//            return "Box: " + items.size() + " item" + ", total weight " + this.weight() + " kg";
//        }
        
        return "Box: " + items.size() + " items" + ", total weight " + this.weight() + " kg";
    }
}
