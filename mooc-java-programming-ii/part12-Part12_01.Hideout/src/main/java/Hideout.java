/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */

public class Hideout<T> {
    private T item;     
    
    public void putIntoHideout(T toHide) {
        item = toHide;
    }
    
    public T takeFromHideout() {
        T toRemove = item;
        item = null;
        return toRemove;
    }
    
    public boolean isInHideout() {
        return item != null;
    }
}
