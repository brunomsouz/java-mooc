
public class Main {

    public static void main(String[] args) {
        Box boxOfBoxes = new Box(20);
        Box box = new Box(10);
        Box box2 = new Box(15);
        boxOfBoxes.add(box);
        boxOfBoxes.add(box2);

        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2));
        box.add(new Book("Robert Martin", "Clean Code", 3));
        box.add(new Book("Kent Beck", "Test Driven Development", 5));

        System.out.println(box);

        box2.add(new Book("Frank Herbert", "Dune", 10));
        box2.add(new Book("LoTR", "Tolkien", 5));

        System.out.println(boxOfBoxes);
    }

}
