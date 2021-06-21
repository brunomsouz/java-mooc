
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cube firstCube = new Cube(5);
        Cube secondCube = new Cube(3);
        Cube thirdCube = new Cube(10);
        
        System.out.println(firstCube);
        System.out.println(secondCube);
        System.out.println(thirdCube);
    }
}
