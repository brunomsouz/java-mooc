
public class MainProgram {

    public static void main(String[] args) {
        DecreasingCounter counter = new DecreasingCounter(5);

        counter.printValue();
        counter.reset();
        counter.printValue();
    }
}
