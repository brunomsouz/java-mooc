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

public class HashMap<K, V> {
    public List<Pair<K, V>>[] values;
    public int firstFreeIndex;

    public HashMap() {
        values = new List[32];
        firstFreeIndex = 0;
    }
    
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        
        if (values[hashValue] == null) {
            return null;
        }
        
        List<Pair<K, V>> valuesAtIndex = values[hashValue];
        
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)) {
                return valuesAtIndex.get(i).getValue();
            }
        }
        
        return null;
    }
    
    public void add(K key, V value) {       
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);
        
        if (index < 0) {
            valuesAtIndex.add(new Pair(key, value));
            firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }
        
        if (1.0 * firstFreeIndex / values.length > 0.75) {
            grow();
        }
    }
    
    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }
        
        return values[hashValue];
    }
    
    private int getIndexOfKey(List<Pair<K, V>> list, K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void grow() {
        List<Pair<K, V>>[] newValues = new List[values.length * 2];
        
        for (int i = 0; i < values.length; i++) {
            copy(newValues, i);
        }
        
        values = newValues;
    }
    
    public void copy(List<Pair<K, V>>[] newArray, int index) {
        for (int i = 0; i < values[index].size(); i++) {
            Pair<K, V> value = values[index].get(i);
            
            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }
            
            newArray[hashValue].add(value);
        }
    }
    
    public V remove(K key) {
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }
        
        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }
        
        Pair<K, V> pair = valuesAtIndex.get(index);
        valuesAtIndex.remove(pair);
        return pair.getValue();
    }
}
