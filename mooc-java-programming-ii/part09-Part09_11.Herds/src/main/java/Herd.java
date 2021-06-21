/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
import java.util.List;
import java.util.ArrayList;

public class Herd implements Movable {
    private List<Movable> herd;

    public Herd() {
        herd = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable) {
        herd.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable organism : herd) {
            organism.move(dx, dy);
        }
    }
    
    public String toString() {
        String toReturn = "";
        
        for (Movable organism : herd) {
            toReturn += organism.toString() + "\n";
        }
        
        return toReturn;
    }
}
