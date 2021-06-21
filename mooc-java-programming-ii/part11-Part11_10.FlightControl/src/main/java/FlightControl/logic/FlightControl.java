/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

/**
 *
 * @author bruno
 */

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class FlightControl {
    private final Map<String, Airplane> airplanes;
    private final List<Flight> flights;
    private final Map<String, Place> places;

    public FlightControl() {
        airplanes = new HashMap<>();
        flights = new ArrayList<>();
        places = new HashMap<>();
    }
    
    public void addAirplane(String id, int capacity) {
        airplanes.put(id, new Airplane(id, capacity));
    }
    
    public void addFlight(String airplane, String origin, String destination) {
        places.putIfAbsent(origin, new Place(origin));
        places.putIfAbsent(destination, new Place(destination));
        
        flights.add(new Flight(airplanes.get(airplane),
                places.get(origin), places.get(destination)));
    }
    
    public Airplane getAirplane(String id) {
        return airplanes.get(id);
    }
    
    public Collection<Airplane> getAirplanes() {
        return airplanes.values();
    }
    
    public Collection<Flight> getFlights() {
        return flights;
    }
    
}
