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

public class Suitcase {
    private int maxWeight;
    private ArrayList<Item> items;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        if (item.getWeight() + this.totalWeight() <= this.maxWeight) {
            this.items.add(item);
        }
    }
    
    public int totalWeight() {
        int sum = 0;
        
        for (Item item: this.items) {
            sum += item.getWeight();
        }
        
        return sum;
    }
    
    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        
        Item heaviest = this.items.get(0);
        
        for (Item item: this.items) {
            if (heaviest.getWeight() < item.getWeight()) {
                heaviest = item;
            }
        }
        
        return heaviest;
    }
    
    public void printItems() {
        for (Item item: items) {
            System.out.println(item);
        }
    }
    
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }
        
        if (this.items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }
        
        return this.items.size() + " items (" + this.totalWeight() + " kg)";
    }
}
