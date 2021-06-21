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

public class BoxWithMaxWeight extends Box {
    
    private ArrayList<Item> items;
    private int capacity;
    
    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }
    
    public int getFreeCapacity() {
        int totalWeight = 0;
        
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        
        return capacity - totalWeight;
    }
    
    @Override
    public void add(Item item) {
        if (item.getWeight() <= this.getFreeCapacity()) {
            this.items.add(item);
        }
    }
    
    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
