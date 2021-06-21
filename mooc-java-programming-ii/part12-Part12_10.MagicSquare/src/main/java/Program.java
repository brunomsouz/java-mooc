
public class Program {

    public static void main(String[] args) {
        MagicSquareFactory factory = new MagicSquareFactory();
        
        MagicSquare test = factory.createMagicSquare(5);
        
        System.out.println(test.toString());
    }
}
