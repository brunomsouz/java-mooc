/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class List<T> {

    private T[] values;
    private int firstFreeIndex;

    public List() {
        values = (T[]) new Object[10];
        firstFreeIndex = 0;
    }

    public void add(T value) {
        if (firstFreeIndex == values.length) {
            grow();
        }

        values[firstFreeIndex] = value;
        firstFreeIndex++;
    }

    private void grow() {
        int newSize = values.length + values.length / 2;

        T[] newValues = (T[]) new Object[newSize];

        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i];
        }

        values = newValues;
    }

    public T value(int index) {
        if (index < 0 || index >= firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index
                    + "outside of [0, " + firstFreeIndex + "]");
        }

        return values[index];
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public int indexOf(T value) {
        for (int i = 0; i < firstFreeIndex; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }
    
    private void moveToTheLeft(int start) {
        for (int i = start; i < firstFreeIndex - 1; i++) {
            values[i] = values[i + 1];
        }
    }

    public void remove(T value) {
        int index = indexOf(value);
        
        if (index >= 0) {
            moveToTheLeft(index);
            firstFreeIndex--;
        }        
    }

    public int size() {
        return firstFreeIndex;
    }
}
