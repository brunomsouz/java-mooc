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

public class Hold {

    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (suitcase.totalWeight() + this.totalWeight() <= this.maxWeight) {
            this.suitcases.add(suitcase);
        }
    }

    public int totalWeight() {
        int sum = 0;

        for (Suitcase suitcase : this.suitcases) {
            sum += suitcase.totalWeight();
        }

        return sum;
    }
    
    public void printItems() {
        for (Suitcase suitcase: this.suitcases) {
            suitcase.printItems();
        }
    }

    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }

        if (this.suitcases.size() == 1) {
            return "1 suitcase (" + this.totalWeight() + " kg)";
        }

        return this.suitcases.size() + " suitcases (" + this.totalWeight() + " kg)";
    }
}
