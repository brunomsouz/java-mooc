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
import java.util.List;

public class Pipe<T> {
    private final List<T> pipe;
    
    public Pipe() {
        pipe = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        pipe.add(value);
    }
    
    public T takeFromPipe() {
        if (!pipe.isEmpty()) {
            return pipe.remove(0);
        }
        
        return null;
    }
    
    public boolean isInPipe() {
        return !pipe.isEmpty();
    }
}
