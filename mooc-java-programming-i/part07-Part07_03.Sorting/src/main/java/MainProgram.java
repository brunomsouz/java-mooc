import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {1, 3, 7, 9, 1, 2, 4};
        
        sort(array);
        
        System.out.println(Arrays.toString(array));
    }
    
    public static void sort(int[] array) {
        int index = 0;
        
        while (index < array.length) { 
            System.out.println(Arrays.toString(array));
            
            int index2 = indexOfSmallestFrom(array, index);
            swap(array, index, index2);
            
            index++;
        }
    }
    
    public static int smallest(int[] array) {
        int smallest = array[0];
        
        for (int number: array) {
            if (number < smallest) {
                smallest = number;
            }
        }
        
        return smallest;
    }
    
    public static int indexOfSmallest(int[] array) {
        int index = 0;
        
        while (index < array.length) {
            if (array[index] == smallest(array)) {
                break;
            }
            
            index++;
        }
        
        return index;
    }
    
    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        int secondSmallest = array[startIndex];
        int secondSmallestIndex = startIndex;
        
        while (startIndex < array.length) {
            if (array[startIndex] < secondSmallest) {
                secondSmallest = array[startIndex];
                secondSmallestIndex = startIndex;
            }
            
            startIndex++;
        }
        
        return secondSmallestIndex;
    }
    
    public static void swap(int[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        
        int aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

}
