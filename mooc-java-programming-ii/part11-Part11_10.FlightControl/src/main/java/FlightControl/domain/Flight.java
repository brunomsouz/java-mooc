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
public class Flight {
    private final Airplane airplane;
    private final Place origin;
    private final Place destination;

    public Flight(Airplane airplane, Place origin, Place destination) {
        this.airplane = airplane;
        this.origin = origin;
        this.destination = destination;
    }
    
    @Override
    public String toString() {
        return airplane.toString() + " (" + origin.toString() + "-"
                + destination.toString() + ")";
    }
}
