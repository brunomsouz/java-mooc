/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author bruno
 */
import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean state;

    public TemperatureSensor() {        
        this.state = false;
    }
    
    @Override
    public boolean isOn() {
        return state;
    }
    
    @Override
    public void setOn() {
        state = true;
    }
    
    @Override
    public void setOff() {
        state = false;
    }
    
    @Override
    public int read() {
        if (this.isOn()) {
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException();
        }
    }
}
