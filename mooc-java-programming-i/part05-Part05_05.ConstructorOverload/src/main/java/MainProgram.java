
public class MainProgram {

    public static void main(String[] args) {
        Product door = new Product("Door");
        Product table = new Product("Table", "DC");
        Product chair = new Product("Chair", 5);
        
        System.out.println(door);
        System.out.println(table);
        System.out.println(chair);
    }
}
