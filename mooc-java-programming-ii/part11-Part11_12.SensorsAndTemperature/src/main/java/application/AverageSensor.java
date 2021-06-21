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
import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private final List<Sensor> sensors;
    private final List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return readings;
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn()) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
    }

    @Override
    public int read() {
        if (!this.isOn()) {
            throw new IllegalStateException("Sensor is turned off");
        } else if (this.sensors.isEmpty()) {
            throw new IllegalStateException("Sensor list is empty");
        }

        int sum = 0;

        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }

        int average = sum / sensors.size();

        readings.add(average);

        return average;
    }
}
