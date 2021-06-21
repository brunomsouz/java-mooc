package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) throws Exception {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Invalid name argument");
        } else if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid age argument");
        }
        
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
