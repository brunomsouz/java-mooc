
public class Program {

    public static void main(String[] args) {
        int[][] array = new int[2][3];
        array[0][0] = 4;
        array[0][1] = 5;
        array[0][2] = 6;
        array[1][0] = 7;
        array[1][1] = 8;
        array[1][2] = 9;
        
        System.out.println(arrayAsString(array));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder arrayAsString = new StringBuilder();
        
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                arrayAsString.append(array[row][column]);
            }
            
            arrayAsString.append("\n");
        }
        
        return arrayAsString.toString();
    }
}
