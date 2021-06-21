
public class Main {

    public static void main(String[] args) {

        // Try out your class here

        Stack stack = new Stack();
        
        System.out.println(stack.isEmpty());
        stack.add("Bruno");
        stack.add("Moreira");
        stack.add("de");
        stack.add("Souza");
        System.out.println(stack.values());
        String taken = stack.take();
        System.out.println(taken);
        System.out.println(stack.values());
    }
}
