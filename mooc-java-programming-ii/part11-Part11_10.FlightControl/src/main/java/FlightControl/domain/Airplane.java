/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author bruno
 */
public class Airplane {
    private final String id;
    private final int capacity;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
    
    public String getId() {
        return id;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    @Override
    public String toString() {
        return id + " (" + capacity + " capacity)";
    }
}
