
public class MainProgram {

    public static void main(String[] args) {
        // Test your counter here
        
        Counter first = new Counter(4);
        
        first.increase(5);
        first.increase();
        first.decrease(3);
        first.decrease();
        
        System.out.println(first.value());
    }
}
